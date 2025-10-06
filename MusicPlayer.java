package jlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer 
{
    private Player player;
    private BufferedInputStream bis;
    private FileInputStream fis;
    private File file;
    private boolean isPaused = false;
    private long pausePosition = 0;

    public MusicPlayer()
 {
        JFrame mainFrame = new JFrame("Music Player");
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton chooseButton = new JButton("Choose Your Song");
        chooseButton.addActionListener(new ActionListener()
	 {
            @Override
            public void actionPerformed(ActionEvent e) 
	{
                openDialog();
            }
        });
        
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() 
	{
            @Override
            public void actionPerformed(ActionEvent e) 
	{
                playAudio();
            }
        });
        
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() 
	{
            @Override
            public void actionPerformed(ActionEvent e)
	 {
                pauseAudio();
            }
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() 
	{
            @Override
            public void actionPerformed(ActionEvent e) 
	{
                stopAudio();
            }
        });

        mainFrame.add(chooseButton);
        mainFrame.add(playButton);
        mainFrame.add(pauseButton);
        mainFrame.add(stopButton);
        
        mainFrame.setVisible(true);
    }

    void openDialog() 
	{
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) 
	{
            try {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } catch (IOException | JavaLayerException e) 
	{
                e.printStackTrace();
            }
        }
    }

    void playAudio() {
        if (player != null) 
	{
            new Thread(() -> 
	{
                try {
                    if (isPaused)
	 {
                        bis.skip(pausePosition);
                        isPaused = false;
                    } else
	 {
                        player = new Player(bis);
                    }
                    player.play();
                } catch (JavaLayerException e) 
	{
                    e.printStackTrace();
                } catch (Exception e) 
		{
                    e.printStackTrace(); // Handle EOF and other exceptions
                }
            }).start();
        }
    }

    void pauseAudio() {
        if (player != null) 
	{
            try {
                pausePosition = bis.available(); // Save the position
                player.close(); // Stop the player
                isPaused = true;
            } catch (IOException e) 
	{
                e.printStackTrace();
            }
        }
    }

    void stopAudio() 
	{
        if (player != null) 
	{
            player.close();
            isPaused = false;
            pausePosition = 0; // Reset pause position
        }
    }

    public static void main(String[] args) 
	{
        new MusicPlayer();
    }
}