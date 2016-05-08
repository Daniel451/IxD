/**
 * bibGUI - eigentliche GUI-Klasse
 *
 * @author Franziska Kissel
 * @author Daniel Speck
 * @author Fabian Behrendt
 * @author Philipp Liebe
 */

package aufgabe04;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

class bibGUI extends JFrame implements ActionListener {
	// Fenster und Container, um Inhalt darin zu platzieren
	private JFrame content;
	private Container container;
	
	//Menüleiste
	private JMenuBar menuBar;
	
	//Menüeinträge
	private JMenu datei;
	private JMenu datenbank;
	private JMenu fenster;
	private JMenu hilfe;
	
	//Untermenüeinträge
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

    /**
     * Konstruktor
     */
	public bibGUI()
    {
        // Das Hauptfenster erzeugen
		content = new JFrame("Bibliothek GUI");
		container = content.getContentPane();
		
		// Buttons erzeugen
		add_user = new JButton("Benutzer hinzufügen");
		add_user.addActionListener(this);
		add_book = new JButton("Buch hinzufügen");
		add_book.addActionListener(this);
		returnBook = new JButton("Rückgabe");
		returnBook.addActionListener(this);
		rentBook = new JButton("Verleih");
		rentBook.addActionListener(this);

        // Menüleiste erzeugen
		menuBar = new JMenuBar();
		
		// Menüelemente erzeugen
		datei = new JMenu("Datei");
		datenbank = new JMenu("Datenbank");
		fenster = new JMenu("Fenster");
		hilfe = new JMenu("Hilfe");
		
		// Untermenüelemente(-punkte) erzeugen
		oeffnen = new JMenuItem("Öffnen");
		oeffnen.addActionListener(this);
		beenden = new JMenuItem("Beenden");
		beenden.addActionListener(this);
		
		benutzer = new JMenuItem("Benutzer");
		benutzer.addActionListener(this);
		buecher = new JMenuItem("Bücher");
		buecher.addActionListener(this);
		
		neuesFenster = new JMenuItem("Neues Fenster");
		neuesFenster.addActionListener(this);
		navigation = new JMenuItem("Navigation");
		navigation.addActionListener(this);
		
		faq = new JMenuItem("FAQ");
		faq.addActionListener(this);
		anleitung = new JMenuItem("Anleitung");
		anleitung.addActionListener(this);
		ueber = new JMenuItem("Über");
		ueber.addActionListener(this);
		
		// Menüelemente hinzufügen
		menuBar.add(datei);
		menuBar.add(datenbank);
		menuBar.add(fenster);
		menuBar.add(hilfe);
		
		// Untermenüelemente hinzufügen
		datei.add(oeffnen);
		datei.add(beenden);
		
		datenbank.add(benutzer);
		datenbank.add(buecher);
		
		fenster.add(neuesFenster);
		fenster.add(navigation);
		
		hilfe.add(faq);
		hilfe.add(anleitung);
		hilfe.add(ueber);

        // Menüleiste für unserer content frame setzen
		content.setJMenuBar(menuBar);

		// eigenes GridLayout erzeugen
		GridLayout ourLayout = new GridLayout(2, 2);

        // vertikale und horizontale Abstände in unserem Layout setzen
		ourLayout.setHgap(50);
		ourLayout.setVgap(50);
		
		// TODO VerticalFlowLayot?
        // Panels erzeugen, als Container für Inhalt um verschiedene Layout-Manager mixen zu können
		JPanel allContentPane = new JPanel(new FlowLayout());
		JPanel contentPane = new JPanel(ourLayout);
		allContentPane.add(contentPane);
		allContentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		// den Hauptcontainer auf bestimmte Größe setzen und Inhalt (Buttons) hinzufügen
		contentPane.setPreferredSize(new Dimension(400, 200));
		contentPane.setMaximumSize(new Dimension(400, 200));
		contentPane.add(add_user);
		contentPane.add(add_book);
		contentPane.add(returnBook);
		contentPane.add(rentBook);

        // dem Hauptfenster diese Container hinzufügen
		content.add(allContentPane);

        // TODO der auskommentierte Code hier kann weg?!
		// content.setSize(800, 600);

        // Inhalt pack'en, Größe unveränderbar setzen, Beenden bei Klick auf "X" setzen und anzeigen (visible setzen)
		content.pack();
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setVisible(true);
	}

    /**
     * Action handler, der geworfene events abfängt und verarbeitet
     *
     * @param e das gesendete Event, hier z.B. ein Klick eines Buttons
     */
	public void actionPerformed(ActionEvent e)
	{
		JDialog popup = new JDialog();

        // wir switchen über die Events, um festzustellen, welcher Button geklickt wurde
		switch(e.getActionCommand())
		{
			case "Benutzer hinzufügen":
				popup = addUserWindow();
				System.out.println("Benutzer hinzufügen wurde gedrückt");
				break;
			case "Buch hinzufügen":
				popup = addBookWindow();
				System.out.println("Buch hinzufügen wurde gedrückt");
				break;
			case "Rückgabe":
				popup = new JDialog(content, "Rückgabe" ,true);
				System.out.println("Rückgabe wurde gedrückt");
				break;
			case "Verleih":
				popup = new JDialog(content, "Verleih" ,true);
				System.out.println("Verleih wurde gedrückt");
				break;
		}
		
		popup.setVisible(true);
	}

    /**
     * Pop-Up-Window für "Benutzer hinzufügen"
     */
	public JDialog addUserWindow()
    {
		JDialog popupAddUser = new JDialog(content, "Benutzer hinzufügen", true);
		
		JPanel contentAddUser = new JPanel(new GridLayout(7, 2, 10, 10));
		contentAddUser.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel name = new JLabel("Name des Benutzers:");
		JTextField nameField = new JTextField();
		
		JLabel id = new JLabel("ID des Benutzers:");
		JSpinner idSpinner = new JSpinner();
		
		JLabel address = new JLabel("Adresse des Benutzers:");
		JTextField addressField = new JTextField();
		
		JLabel birthday = new JLabel("Geburtstag des Benutzers:");
		JTextField birthdayField = new JTextField();
		
		JLabel registrationDate = new JLabel("Aufnahmedatum des Benutzers:");
		JTextField registrationDateField = new JTextField();
		
		JLabel gender = new JLabel("Geschlecht des Benutzers:");
		JRadioButton maleButton = new JRadioButton("männlich");
		JRadioButton femaleButton = new JRadioButton("weiblich");
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		
		JPanel genderPanel = new JPanel(new GridLayout(2, 0));
		genderPanel.add(maleButton);
		genderPanel.add(femaleButton);
		
		JButton add = new JButton("Aufnehmen");
		JButton cancel = new JButton("Abbrechen");
		
		contentAddUser.add(name);
		contentAddUser.add(nameField);
		contentAddUser.add(id);
		contentAddUser.add(idSpinner);
		contentAddUser.add(address);
		contentAddUser.add(addressField);
		contentAddUser.add(birthday);
		contentAddUser.add(birthdayField);
		contentAddUser.add(registrationDate);
		contentAddUser.add(registrationDateField);
		contentAddUser.add(gender);
		contentAddUser.add(genderPanel);
		contentAddUser.add(add);
		contentAddUser.add(cancel);
		
		popupAddUser.add(contentAddUser);
		popupAddUser.pack();
		popupAddUser.setResizable(false);
		
		return popupAddUser;
	}

    /**
     * Pop-Up-Window für "Buch hinzüfgen"
     */
	public JDialog addBookWindow() {
		JDialog popupAddBook = new JDialog(content, "Buch hinzufügen" ,true);
		
		JPanel contentAddBook = new JPanel(new GridLayout(6, 2, 10, 10));
		contentAddBook.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel title = new JLabel("Titel des Buches:");
		JTextField titleField = new JTextField();
		
		JLabel isbn = new JLabel("ISBN des Buches:");
		JTextField isbnField = new JTextField();
		
		JLabel rentalState = new JLabel("Verliehen?");
		JCheckBox rentalStateCheckBox = new JCheckBox();
		
		JLabel borrower = new JLabel("ID des Entleihers:");
		JSpinner borrowerSpinner = new JSpinner();
		
		JLabel keyWords = new JLabel("Schlagworte:");
		String[] keyWordsStrings = { "Krimi", "Fantasy", "Sci-Fi", "Kurzgeschichte", "Horror", "Kinderbuch"};
		JComboBox<String> keyWordsDropdown= new JComboBox<String>(keyWordsStrings);
		keyWordsDropdown.setEnabled(true);
		
		JButton add = new JButton("Aufnehmen");
		JButton cancel = new JButton("Abbrechen");
		
		contentAddBook.add(title);
		contentAddBook.add(titleField);
		contentAddBook.add(isbn);
		contentAddBook.add(isbnField);
		contentAddBook.add(rentalState);
		contentAddBook.add(rentalStateCheckBox);
		contentAddBook.add(borrower);
		contentAddBook.add(borrowerSpinner);
		contentAddBook.add(keyWords);
		contentAddBook.add(keyWordsDropdown);
		contentAddBook.add(add);
		contentAddBook.add(cancel);
		
		popupAddBook.add(contentAddBook);
		popupAddBook.pack();
		popupAddBook.setResizable(false);
		
		return popupAddBook;
	}
	
	public JDialog returnWindow() {
		JDialog popupAddUser = new JDialog(content, "Benutzer hinzufügen" ,true);
		
		return popupAddUser;
	}
	
	public JDialog rentalWindow() {
		JDialog popupAddUser = new JDialog(content, "Benutzer hinzufügen" ,true);
		
		return popupAddUser;
	}
}
