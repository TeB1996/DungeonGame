package com.TeB.MapEditor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CreateMap extends JPanel{
	
	public static JSlider slider;
	public static JSlider slider_1;
	public static JSlider slider_2;
	
	public static String mapName;
	
	private JPanel contentPane;


	public CreateMap() {

	}
	
	public void openOptionsMenu(){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 260, 213);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setResizable(true);

		frame.add(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		final JFormattedTextField mapName = new JFormattedTextField();
		mapName.setText("mapName");
		mapName.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CreateMap.mapName = mapName.getText();
				System.out.println(CreateMap.mapName);
			}
			
		});
		panel.add(mapName);
		
		
		
		JFormattedTextField frmtdtxtfldRed = new JFormattedTextField();
		frmtdtxtfldRed.setText("ZoomSize");
		panel.add(frmtdtxtfldRed);

		slider = new JSlider();
		slider.setMinimum(0);
		slider.setMaximum(50);
		panel.add(slider);

		JFormattedTextField frmtdtxtfldGreen = new JFormattedTextField();
		frmtdtxtfldGreen.setText("ChunkWidth (62 blocks)");
		panel.add(frmtdtxtfldGreen);

		slider_1 = new JSlider();
		slider_1.setMinimum(0);
		slider_1.setMaximum(100);
		panel.add(slider_1);

		JFormattedTextField frmtdtxtfldBlue = new JFormattedTextField();
		frmtdtxtfldBlue.setText("ChunkHeight (44 blocks)");
		panel.add(frmtdtxtfldBlue);

		slider_2 = new JSlider();
		slider_2.setMinimum(0);
		slider_2.setMaximum(100);
		panel.add(slider_2);
		
		
		
		
	}

	public void makeFiles(String mapName, int mapWidth, int mapHeight,
			double mapScale, int spawnBlockX, int spawnBlockY) {

		int a = 0;
		
		File dir = new File("maps/" + mapName);
		dir.mkdir();
		
		try {
			Formatter f = new Formatter("maps/" + mapName + "/" + mapName);

			for (int i = 0; i < 62 * mapWidth * 44 * mapHeight; i++) {
				a++;
				if (a != 1)
					f.format("%s", " ");
				if (a == 62 * mapWidth) {
					a = 0;
					f.format("%s", 0);
					f.format("\n", "");
				} else {
					f.format("%s", 0);
				}
			}
			f.close();

			Formatter fInfo = new Formatter("maps/" + mapName + "/" + mapName
					+ "Info");

			fInfo.format("" + mapWidth + " ", 0);
			fInfo.format("" + mapHeight + " ", 0);
			fInfo.format("" + mapScale + " ", 0);
			fInfo.format("" + spawnBlockX + " ", 0);
			fInfo.format("" + spawnBlockY + " ", 0);

			fInfo.close();

			new Formatter("maps/" + mapName + "/" + mapName + "Chest");
			new Formatter("maps/" + mapName + "/" + mapName + "Sign");
			new Formatter("maps/" + mapName + "/" + mapName + "Light");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
