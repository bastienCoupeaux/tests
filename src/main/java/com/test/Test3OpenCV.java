package com.test;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Test3OpenCV {

    public static void main(String[] args) {
        OpenCV.loadLocally();
        System.out.println("OpenCV version : " + Core.VERSION);

        Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println(m.dump());

        // Chargement de l'image (chemin relatif à la racine du projet)
        String chemin = "/Users/macbook/Downloads/Gemini_Generated_Image_3zl4mk3zl4mk3zl4.png";
        Mat image = Imgcodecs.imread(chemin);

        if (image.empty()) {
            System.out.println("Impossible de charger l'image : " + chemin);
            return;
        }
        System.out.println("Image chargée : " + image.cols() + " x " + image.rows());

        BufferedImage bufferedImage = matToBufferedImage(image);
        SwingUtilities.invokeLater(() -> afficher(bufferedImage));
    }

    private static BufferedImage matToBufferedImage(Mat mat) {
        int type = (mat.channels() == 1)
                ? BufferedImage.TYPE_BYTE_GRAY
                : BufferedImage.TYPE_3BYTE_BGR;
        BufferedImage img = new BufferedImage(mat.cols(), mat.rows(), type);
        byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        mat.get(0, 0, data);
        return img;
    }

    private static void afficher(BufferedImage img) {
        JFrame frame = new JFrame("Test 3 - OpenCV");
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
