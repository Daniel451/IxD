package aufgabe04;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class bibGUI extends JFrame implements ActionListener {
	//
	private JFrame content;
	private Container container;
	
	//Men�leiste
	private JMenuBar menuBar;
	
	//Men�eintr�ge
	private JMenu datei;
	private JMenu datenbank;
	private JMenu fenster;
	private JMenu hilfe;
	
	//Untermen�eintr�ge
	//datei
	private JMenuItem oeffnen;
	private JMenuItem beenden;
	
	//datenbank
	private JMenuItem benutzer;
	private JMenuItem buecher;
	
	//fenster
	private JMenuItem neuesFenster;
	private JMenuItem navigation;
	
	//hilfe
	private JMenuItem faq;
	private JMenuItem anleitung;
	private JMenuItem ueber;
	
	private JButton add_user;
	private JButton add_book;
	private JButton returnBook;
	private JButton rentBook;
	
	public bibGUI() {
		content = new JFrame("Bibliothek GUI");
		container = content.getContentPane();
		
		//Buttons erzeugen
		add_user = new JButton("Benutzer hinzuf�gen");
		add_user.addActionListener(this);
		add_book = new JButton("Buch hinzuf�gen");
		add_book.addActionListener(this);
		returnBook = new JButton("R�ckgabe");
		returnBook.addActionListener(this);
		rentBook = new JButton("Verleih");
		rentBook.addActionListener(this);
		
		
		menuBar = new JMenuBar();
		
		//Men�elemente erzeugen
		datei = new JMenu("Datei");
		datenbank = new JMenu("Datenbank");
		fenster = new JMenu("Fenster");
		hilfe = new JMenu("Hilfe");
		
		//Untermen�elemente erzeugen
		oeffnen = new JMenuItem("�ffnen");
		oeffnen.addActionListener(this);
		beenden = new JMenuItem("Beenden");
		beenden.addActionListener(this);
		
		benutzer = new JMenuItem("Benutzer");
		benutzer.addActionListener(this);
		buecher = new JMenuItem("B�cher");
		buecher.addActionListener(this);
		
		neuesFenster = new JMenuItem("Neues Fenster");
		neuesFenster.addActionListener(this);
		navigation = new JMenuItem("Navigation");
		navigation.addActionListener(this);
		
		faq = new JMenuItem("FAQ");
		faq.addActionListener(this);
		anleitung = new JMenuItem("Anleitung");
		anleitung.addActionListener(this);
		ueber = new JMenuItem("�ber");
		ueber.addActionListener(this);
		
		//Men�elemente hinzuf�gen
		menuBar.add(datei);
		menuBar.add(datenbank);
		menuBar.add(fenster);
		menuBar.add(hilfe);
		
		//Untermen�elemente hinzuf�gen
		datei.add(oeffnen);
		datei.add(beenden);
		
		datenbank.add(benutzer);
		datenbank.add(buecher);
		
		fenster.add(neuesFenster);
		fenster.add(navigation);
		
		hilfe.add(faq);
		hilfe.add(anleitung);
		hilfe.add(ueber);
		
		content.setJMenuBar(menuBar);

		// creation stuff
		GridLayout ourLayout = new GridLayout(2, 2);
		ourLayout.setHgap(50);
		ourLayout.setVgap(50);
		
		// TODO VerticalFlowLayot
		JPanel allConentPane = new JPanel(new FlowLayout());
		JPanel contentPane = new JPanel(ourLayout);
		allConentPane.add(contentPane);
		
		
		contentPane.setPreferredSize(new Dimension(400, 200));
		contentPane.setMaximumSize(new Dimension(400, 200));
		contentPane.add(add_user);
		contentPane.add(add_book);
		contentPane.add(returnBook);
		contentPane.add(rentBook);
		
		content.add(allConentPane);
		
		content.setSize(800, 600);
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JDialog bla = new JDialog();
				
		switch(e.getActionCommand())
		{
			// TODO 4x kopieren
			case "Benutzer hinzuf�gen":
				bla = new JDialog(content, "Benutzer hinzuf�gen" ,true);
				System.out.println("Benutzer hinzuf�gen wurde gedr�ckt");
				break;
		}
		
		bla.setVisible(true);
	}
}
