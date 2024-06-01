/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaproject;
import java.awt.Color;
/**
 *
 * @author deniz
 */
public class DuvarYazisi {
    
    private String text;
    private Color fontColor;
    
    
    public DuvarYazisi(String text,Color fontColor)
    {
        this.text = text;
        this.fontColor = fontColor;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
       this.text = text;
    }
    
    public Color getColor()
    {
        return this.fontColor;
    }
    
    public void setColor(Color color)
    {
        this.fontColor = color;
    }
    
    
}
