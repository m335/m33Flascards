package com.tbz.flashcards;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;

public class FotoShootActivity extends Activity implements SurfaceHolder.Callback {

	private static final String TAG = FotoShootActivity.class.getSimpleName();

	private Camera camera = null;
	private SurfaceHolder holder = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Benutzeroberfläche anzeigen
		setContentView(R.layout.activity_foto_shoot);
		final SurfaceView view = (SurfaceView) findViewById(R.id.view);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		holder = view.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		// wir brauchen dieses Objekt für die Aufnahme
		final KameraCallbacks callbacks = new KameraCallbacks();
		// auf Anklicken reagieren
		view.setOnClickListener(new OnClickListener() {
		   @Override
		   public void onClick(View v) {
		      camera.takePicture(callbacks, null, callbacks);
		   }
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		// ganz wichtig: Callback entfernen und Kamera freigeben
		if (camera != null) {
			holder.removeCallback(this);
			camera.release();
			camera = null;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		// prüfen, ob Kamera vorhanden ist
		camera = Camera.open();
		if (camera != null) {
			Camera.Parameters p = camera.getParameters();
			List<Camera.Size> list = p.getSupportedPreviewSizes();
			Camera.Size size = list.get(list.size() - 1);
			p.setPreviewSize(size.width, size.height);
			camera.setParameters(p);
			holder.addCallback(this);
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			camera.setPreviewDisplay(holder);
			camera.startPreview();
		} catch (IOException e) {
			Log.e(TAG, "surfaceCreated()", e);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Camera.Parameters parameters = camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG); 
        parameters.set("orientation", "portrait");
        parameters.setRotation(90);
        camera.setParameters(parameters);
	}
}