
package medialibrary;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import java.util.LinkedList;

//set up movie class to store details
class Movie{
    String name;
    String media;
    int year;
    
    public Movie(String n, String m, int y){
        name = n;
        media = m;
        year = y;
    }
}

class GUI extends JFrame{
    //gui elements
    private JPanel JPanelInput;
    private JPanel JPanelOutput;
    
    private JLabel JLabelMovieName;
    private JLabel JLabelMedia;
    private JLabel JLabelReleaseYear;
    
    
    private JTextField JTextFieldMovieName;
    private JTextField JTextFieldMedia;
    private JTextField JTextFieldReleaseYear;
    
    private JButton JButtonAddMovie;
    private JButton JButtonShowMovie;
    private JTextArea JTextAreaOutput;
    
    //linked list setup
    LinkedList<Movie> list = new LinkedList<>();
    public GUI(){
    createUserInterface();
}
    
    private void createUserInterface(){
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        //GUI element setup and positioning
        JPanelInput = new JPanel();
        JPanelInput.setLayout(null);
        JPanelInput.setBorder(new TitledBorder("input movie"));
        JPanelInput.setBounds(10, 10, 250, 250);
        contentPane.add(JPanelInput);
        
        JLabelMovieName = new JLabel();
        JLabelMovieName.setBounds(10, 30, 50, 15); 
        JLabelMovieName.setText("Movie:");
        JPanelInput.add(JLabelMovieName);
        
        JLabelMedia = new JLabel();
        JLabelMedia.setBounds(10, 60, 50, 15); 
        JLabelMedia.setText("Media:");
        JPanelInput.add(JLabelMedia);
        
        JLabelReleaseYear = new JLabel();
        JLabelReleaseYear.setBounds(10, 90, 100, 15); 
        JLabelReleaseYear.setText("Release Year:");
        JPanelInput.add(JLabelReleaseYear);
        
        JTextFieldMovieName = new JTextField();
        JTextFieldMovieName.setBounds(135, 30, 100, 15); 
        JPanelInput.add(JTextFieldMovieName);
        
        JTextFieldMedia = new JTextField();
        JTextFieldMedia.setBounds(135, 60, 100, 15); 
        JPanelInput.add(JTextFieldMedia);
        
        JTextFieldReleaseYear = new JTextField();
        JTextFieldReleaseYear.setBounds(135, 90, 100, 15); 
        JPanelInput.add(JTextFieldReleaseYear);
        
        JButtonAddMovie = new JButton();
        JButtonAddMovie.setBounds(10, 120, 100, 20);//x,y,w,h
        JButtonAddMovie.setText("add movie");
        JPanelInput.add(JButtonAddMovie);
        
        JButtonAddMovie.addActionListener(
            new ActionListener(){ 
                
                public void actionPerformed(ActionEvent event){
                    addMovieJButton(event);
                }
            }  
        );
        
        JPanelOutput = new JPanel();
        JPanelOutput.setLayout(null);
        JPanelOutput.setBorder(new TitledBorder("movie"));
        JPanelOutput.setBounds(260, 10, 325, 250);
        contentPane.add(JPanelOutput);
        
        JTextAreaOutput = new JTextArea();
        JTextAreaOutput.setBounds(10,20,300,175);
        JTextAreaOutput.setEditable(false);
        JTextAreaOutput.setText("Movie\tmedia\trelease year\n");
        
        JPanelOutput.add(JTextAreaOutput);
        
        JButtonShowMovie = new JButton();
        JButtonShowMovie.setBounds(115, 210, 100, 20);//x,y,w,h
        JButtonShowMovie.setText("show movies");
        JPanelOutput.add(JButtonShowMovie);
       
        JButtonShowMovie.addActionListener(
            new ActionListener(){ 
                
                public void actionPerformed(ActionEvent event){
                    showMovieButton(event);
                }
            }  
        );
        
        setTitle("Movie Database"); //sets the title bar text of the window
        setSize(600, 300); //set window's initial size
        setVisible(true); //display the window
}
    //logic to collect data from textfield and enter into liinked list
    private void addMovieJButton(ActionEvent event){
        String movie = JTextFieldMovieName.getText();
        String media = JTextFieldMedia.getText();
        int release = Integer.parseInt(JTextFieldReleaseYear.getText());
        
        
        Movie m = new Movie(movie, media, release);
        
        list.add(m);
        
    }
    //logic to output data to textAreaOutput
    private void showMovieButton(ActionEvent event){
        JTextAreaOutput.setText("Movie\tmedia\trelease year\n");
        for(Movie m: list){
            JTextAreaOutput.append(m.name+"\t"+m.media+"\t"+m.year+"\n");
            
        }
    }
}

public class MediaLibrary {

    
    public static void main(String[] args) {
        GUI application = new GUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
