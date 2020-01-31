/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * Add your docs here.
 */
public class Camera {
    private CvSink sink;
	private CvSource source;

	private UsbCamera cam;

	public Camera(String name, int dev, int w, int h) {
		cam = CameraServer.getInstance().startAutomaticCapture(name, dev);
		cam.setResolution(w, h);
		sink = CameraServer.getInstance().getVideo(cam);
		source = CameraServer.getInstance().putVideo(name, w, h);
	}

	public Mat getImage() {
		Mat mat = new Mat();
		sink.grabFrame(mat);
		return mat;
	}

	public void putImage(Mat mat) {
		source.putFrame(mat);
	}

	public void showLive() {
		putImage(getImage());
	}
}
