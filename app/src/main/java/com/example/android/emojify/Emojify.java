package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by mintra on 5/15/17.
 */

public class Emojify {

    public static void detectFaces(Context context, Bitmap picture) {
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(picture).build();
        SparseArray<Face> faces = detector.detect(frame);

        if(faces.size() == 0) {
            Toast.makeText(context, "No face detected", Toast.LENGTH_SHORT).show();

        }
        detector.release();

    }
}
