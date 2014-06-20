/**@author Fabienne Pfister
 * @version V1
 */
package com.tbz.flashcards;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.ContextWrapper;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.util.Log;

public class KameraCallbacks implements ShutterCallback, PictureCallback {

	private static final String TAG = KameraCallbacks.class.getSimpleName();
	private Context context;

	@Override
	public void onShutter() {
		Log.d(TAG, "onShutter()");
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		Log.d(TAG, "onPictureTaken()");
		// In welchem Verzeichnis soll die Datei abgelegt werden?
	//	File dir = Environment
	//			.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		ContextWrapper cw = new ContextWrapper(getApplicationContext(this.context));
        // path to /data/data/yourapp/app_data/imageDir
       File dir = cw.getDir("image", Context.MODE_WORLD_READABLE);
		// für den Fall der Fälle: Verzeichnisse anlegen
		dir.mkdirs();
		// Name der Datei
		File file = new File(dir, Long.toString(System.currentTimeMillis())
				+ ".jpg");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		// Datei gepuffert schreiben
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(data);
		} catch (IOException e) {
			Log.e(TAG, "onPictureTaken()", e);
		} finally {
			// Ströme schließen - etwaige Exceptions ignorieren
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			// Live-Vorschau neu starten
			camera.startPreview();
		}
	}
	/**@return Context Den aktuellen Context zurückgeben
	 */
	public Context getApplicationContext(Context context){
	return context;
	}
}
