package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static int detectFaces(Context aContext, Bitmap aBitmap) {

        FaceDetector detector = new FaceDetector.Builder(aContext)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(aBitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        detector.release();

        return faces.size();

    }
}
