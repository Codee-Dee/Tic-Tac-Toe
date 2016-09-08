package edu.jsu.mcis;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javafx.application.Application; 

abstract public class TicTacToeMain extends Application{
	public static void main(String[] args) {
		JFrame win = new JFrame("Tic Tac Toe");
		win.add(new TicTacToeVC());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
	}
}