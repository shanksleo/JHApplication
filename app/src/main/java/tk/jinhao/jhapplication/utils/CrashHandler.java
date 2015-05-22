package tk.jinhao.jhapplication.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler implements UncaughtExceptionHandler {

	private static CrashHandler crashHandler = new CrashHandler();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	private String filePath = Environment.getExternalStorageDirectory()+File.separator;

	private Context context;
	@Override
	public void uncaughtException(Thread thread,
			Throwable ex) {
		if(ex!=null){
			saveLog2SDcard(ex);
		}
		ActivityManager mActivityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		if(Build.VERSION.SDK_INT<Build.VERSION_CODES.ECLAIR_MR1){
			mActivityManager.killBackgroundProcesses(context.getApplicationInfo().packageName);
		}else{
			android.os.Process.killProcess(android.os.Process.myPid());
		}
	}
	private CrashHandler(){}
	public static CrashHandler getInstance(){
		return crashHandler;
	}

	public void init(Context context){
		this.context = context;
		Thread.setDefaultUncaughtExceptionHandler(this);

	}

	/**
	 * 把异常信息写到sd卡
	 * @param ex
	 */
	private void saveLog2SDcard(Throwable ex){
		if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			return;
		}
		File file = new File(filePath+context.getPackageName()+"/ErrorLog/");
		if(!file.exists()){
			file.mkdirs();
		}
		Writer writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		ex.printStackTrace(pw);
		Throwable cause = ex.getCause();
		while(cause!=null){
			cause.printStackTrace(pw);
			cause = cause.getCause();
		}
		pw.close();
		String time = sdf.format(new Date());
		try {
			FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile()+File.separator+time+"-log.txt");
			fos.write(writer.toString().getBytes());
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
