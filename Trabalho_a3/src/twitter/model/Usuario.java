package twitter.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
    private String id;
    private String name;
    private String username;
    private String created_at;
    private String profile_image_url;

    public Usuario() {
    }

    public Usuario(String id, String name, String username, String created_at, String profile_image_url) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.created_at = created_at;
        this.profile_image_url = profile_image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated_at() throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(created_at);
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public ImageIcon getProfile_image_url() {
        URL url = null;
        try {
            url = new URL(profile_image_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedImage c = null;
        try {
            c = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon image = new ImageIcon(c);

        return image;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }
}
