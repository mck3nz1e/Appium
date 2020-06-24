package ScreenShots;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenCaptureBase64 {

	public static String CaptureScreenShot64(WebDriver driver) throws Exception {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HH.mm.ss").format(Calendar.getInstance().getTime());

		String srcBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		File file = OutputType.FILE.convertFromBase64Png(srcBase64);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/Screenshots/" + timeStamp + ".png"), true);

		return srcBase64;

	}
}
