package com.voting.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.openide.util.Exceptions;

import com.voting.ui.frame.MainUi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rizal
 */
public class UploadImg {

    public static String uploadImage(BufferedImage image, String path, String name) {
        String filename = path + "/" + name, url = "http://address/voting/aset/" + filename;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(check(image), "JPG", os);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        InputStream input = new ByteArrayInputStream(os.toByteArray());
        upload(input, filename);
        return url;
    }

    public static void deletePhoto(String path) {
        String server = MainUi.getAppsIp(),
                filename = path.replace("http://address/voting/aset/", "");
        int port = 21;
        String user = "root";
        String pass = "root";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
            }
            ftpClient.login(user, pass);
            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.deleteFile(filename);
            ftpClient.logout();
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
        }
    }

    private static void upload(InputStream input, String filename) {
        String server = MainUi.getAppsIp();
        int port = 21;
        String user = "root";
        String pass = "root";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
            }
            ftpClient.login(user, pass);
            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.storeFile(filename, input);
            ftpClient.logout();
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
        }
    }

    @SuppressWarnings("unused")
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }

    private static BufferedImage check(BufferedImage img) {
        if (img instanceof BufferedImage) {
            return img;
        } else {
            if (img == null) {
                return null;
            }
            // Create a buffered image with transparency
            BufferedImage bimage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            // Draw the image on to the buffered image
            Graphics2D bGr = bimage.createGraphics();
            bGr.drawImage(img, 0, 0, null);
            bGr.dispose();
            // Return the buffered image
            return bimage;
        }
    }
}
