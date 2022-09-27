package event_management;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class EventManagement<JCalendar> extends JFrame {
	
	JFrame frame2 = new JFrame();
	JTable table = new JTable();
	//JFrame frame2 = new JFrame();
	DefaultTableModel defaultTableModel;
	Connection connection;
	Statement stmnt;
	java.util.Date date1;
	java.sql.Date sqlDate;
	
	JTabbedPane EventPane = new JTabbedPane();
	
	JPanel HomePanel = new JPanel();
	JPanel EventPanel = new JPanel();
	JPanel BookingPanel = new JPanel();
	JPanel LoginPanel = new JPanel();
	JPanel PlacePanel = new JPanel();
	JPanel RegistrationPanel = new JPanel();
	
	
	JLabel eventLabel = new JLabel();
	JLabel bookingLabel = new JLabel();
	JLabel eventName = new JLabel();
	JLabel eventPlace = new JLabel();
	JLabel eventTime = new JLabel();
	JLabel eventcentre = new JLabel();
	JLabel eventDate = new JLabel();
	JLabel eventlimit = new JLabel();
	JLabel eventdescription = new JLabel();
	JLabel loginLabel = new JLabel();
	JLabel userLabel = new JLabel();
	JLabel usernameLabel = new JLabel();
	JLabel passwordLabel = new JLabel();
	JLabel registrationLabel = new JLabel();
	JLabel studentName = new JLabel();
	JLabel studentRegistrationNo = new JLabel();
	JLabel studentMobile = new JLabel();
	JLabel studentEmailId = new JLabel();
	JLabel studentCentre = new JLabel();
	JLabel studentUsername = new JLabel();
	JLabel studentPassword = new JLabel();
	JLabel studenteventLabel = new JLabel();
	JLabel homeLabel = new JLabel();
	
	JButton exitButton = new JButton();
	JButton ongoingButton = new JButton();
	JButton upcomingButton = new JButton();
	JButton bookButton = new JButton();
	JButton eventDetailsButton = new JButton();
	JButton loginButton = new JButton();
	JButton registerButton = new JButton();
	JButton bookingButton = new JButton();
	JButton signinButton = new JButton();
	
	JRadioButton eHall1 = new JRadioButton();
	JRadioButton eHall2 = new JRadioButton();
//	JRadioButton eHall3 = new JRadioButton();
//	JRadioButton eHall4 = new JRadioButton();
	
	
	JTextField eName = new JTextField();
	JTextField eCentre = new JTextField();
	JTextField eDate = new JTextField();
	JTextField eLimit = new JTextField();
	JTextField username = new JTextField();
	JTextField stud_name = new JTextField();
	JTextField stud_username = new JTextField();
	JTextField stud_registrationNo = new JTextField();
	JTextField stud_mobile = new JTextField();
	JTextField stud_email = new JTextField();
	//JTextField stud_centre = new JTextField();
	JTextField stud_name2 = new JTextField();
	
	
	JTextArea eDescription = new JTextArea();
	
	
	JPasswordField password = new JPasswordField();
	JPasswordField stud_password = new JPasswordField();
	
	
	JComboBox timeComboBox = new  JComboBox();
	JComboBox<String> eventComboBox = new JComboBox<String>();
	JComboBox<String> centreComboBox = new JComboBox<String>();
	JComboBox<String> userComboBox = new JComboBox<String>();
	JComboBox<String> studentCentreComboBox = new JComboBox<String>();
	
	JSpinner monthSpinner = new JSpinner(); 
	JSpinner daySpinner = new JSpinner();
	
	
	ImageIcon image1;
	ImageIcon image2;
	ImageIcon image3;
	
	String place;
	String query;
	String[] monthNames = {"January", "February", "March", "April", "May", "June", "July","August","September","October" ,"November" ,"December"};
	
	JCalendar calendar = new JCalendar();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventManagement().show();
	}
	
	@SuppressWarnings("unchecked")
	public EventManagement() {
		setVisible(true);
		setBounds(750, 30, 1200, 700);
		setResizable(true);
		setTitle("JNU EVENT MANAGEMENT");
		//setDefaultCloseOperation
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);}
		});
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridxy = new GridBagConstraints();
		gridxy.gridx = 0;
		gridxy.gridy = 0;
		
		// adding event pane
		
		getContentPane().add(EventPane, gridxy);
		EventPane.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e)
		{
			EventPaneStateChanged(e);
		}
		});
		
		//********************************************* home tab start ******************************************************************
		HomePanel.setLayout(new GridBagLayout());
		// home label
		homeLabel.setText("JNU EVENT MANAGEMENT SYSTEM");
		gridxy.gridx = 1;
		gridxy.gridy = 0;
		gridxy.gridwidth = 1;
		gridxy.anchor = GridBagConstraints.CENTER;
		gridxy.insets = new Insets(10,10,0,0);
		HomePanel.add(homeLabel,gridxy);
		
		// image1
		try {
			image1 = new ImageIcon("music session.png");
			//JLabel displayfield = new JLabel(image1);
			//displayfield.setBounds(10, 20, 100, 100);
			Image img = image1.getImage();
			Image newimg = img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
			image1 = new ImageIcon(newimg);
			JLabel displayfield = new JLabel(image1);
			gridxy.gridx = 0;
			gridxy.gridy = 1;
			HomePanel.add(displayfield, gridxy);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		//image2
		
		try {
			image2 = new ImageIcon("cultural event1.png");
			Image img = image2.getImage();
			Image newimg = img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
			image2 = new ImageIcon(newimg);
			JLabel displayfield = new JLabel(image2);
			gridxy.gridx = 1;
			gridxy.gridy = 1;
			HomePanel.add(displayfield, gridxy);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		//image 3
		
		try {
			image3 = new ImageIcon("dhvani.png");
			Image img = image3.getImage();
			Image newimg = img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
			image3 = new ImageIcon(newimg);
			JLabel displayfield = new JLabel(image3);
			gridxy.gridx = 2;
			gridxy.gridy = 1;
			HomePanel.add(displayfield, gridxy);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		// adding login button
		signinButton.setText("SIGN IN");
		gridxy.gridx = 1;
		gridxy.gridy = 2;
		gridxy.insets = new Insets(5,0,5,0);
		HomePanel.add(signinButton,gridxy);
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			signinButtonActionPerformed(e);
			}
			});
		
		
		
		EventPane.add("HOME" , HomePanel);
		
		//************************************************ home tab end ********************************************************************
		
		
		
		
		
		
		
		
		// ******************************************** start event tab ****************************************************************************** 
		// adding event panel
		EventPanel.setLayout(new GridBagLayout());
		//EventPanel.setBounds(20, 10, 1000, 600);
		
		//Event label
		eventLabel.setText("EVENT PAGE");
		gridxy.gridx = 1;
		gridxy.gridy = 0;
		gridxy.anchor = GridBagConstraints.CENTER;
		gridxy.insets = new Insets(10,10,0,0);
		EventPanel.add(eventLabel,gridxy);
		
		
		// event details button
		eventDetailsButton.setText("EVENT DETAILS");
		gridxy.gridx = 1;
		gridxy.gridy = 1;
		gridxy.insets = new Insets(5,0,5,0);
		EventPanel.add(eventDetailsButton,gridxy);
		eventDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			EventDetailsButtonActionPerformed(e);
			}
			});
		
		
		// ongoing event button
		ongoingButton.setText("ONGOING EVENTS");
		gridxy.gridx= 1;
		gridxy.gridy = 2;
		gridxy.insets = new Insets(5,0,5,0);
		EventPanel.add(ongoingButton,gridxy);
		ongoingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OngoingButtonActionPerformed(e);
			}
		});
		
		// upcoming event button
		upcomingButton.setText("UPCOMING EVENTS");
		gridxy.gridx= 1;
		gridxy.gridy = 3;
		gridxy.insets = new Insets(5,0,5,0);
		EventPanel.add(upcomingButton,gridxy);
		upcomingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpcomingButtonActionPerformed(e);
			}
		});
		
		//exit button
		exitButton.setText("EXIT");
		gridxy.gridx= 1;
		gridxy.gridy = 4;
		gridxy.insets = new Insets(5,0,5,0);
		EventPanel.add(exitButton,gridxy);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}
		});
		
		
		
		// adding event panel to tabbed pane.
		EventPane.add("EVENTS" , EventPanel);
		
		//******************************************** end event tab ****************************************************************************** 
		
		
		
		// ******************************************** start booking tab ****************************************************************************** 
		// adding event panel
				BookingPanel.setLayout(new GridBagLayout());
				BookingPanel.setBounds(20, 10, 1000, 600);
				
				//Booking label
				bookingLabel.setText("BOOK PLACE FOR EVENT");
				gridxy.gridx = 1;
				gridxy.gridy = 0;
				gridxy.anchor = GridBagConstraints.CENTER;
				gridxy.insets = new Insets(10,10,0,0);
				BookingPanel.add(bookingLabel,gridxy);
				
				
				// event NAME label  and textfield
				eventName.setText("EVENT NAME");
				gridxy.gridx = 0;
				gridxy.gridy = 1;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventName,gridxy);
				
				
				//eName.setText("enter event name");
				eName.setColumns(15);
				eName.setHorizontalAlignment(SwingConstants.CENTER);
				eName.setEditable(true);
				//eName.setBackground(Color.gray);
				gridxy.gridx = 1;
				gridxy.gridy = 1;
				BookingPanel.add(eName, gridxy);
				
				
				
				// event TIME label  and textfield
				eventTime.setText("EVENT TIME");
				gridxy.gridx = 0;
				gridxy.gridy = 2;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventTime,gridxy);
				
				timeComboBox.setBackground(Color.WHITE);
				gridxy.gridx = 1;
				gridxy.gridy = 2;
				BookingPanel.add(timeComboBox, gridxy);
				gridxy.anchor = GridBagConstraints.NORTH; 
				BookingPanel.add(timeComboBox,gridxy);
				timeComboBox.addItem("9:00 to 11:00");
				timeComboBox.addItem("12:00 to 2:00");
				timeComboBox.addItem("3:00 to 5:00");
				timeComboBox.addItem("6:00 to 8:00");
				timeComboBox.setSelectedIndex(0);
				
				
				// event DATE label  and textfield
				eventDate.setText("EVENT DATE");
				gridxy.gridx = 0;
				gridxy.gridy = 3;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventDate,gridxy);
				
				calendar.setAutoscrolls(true);
				//calendar.ser
				gridxy.gridx = 1;
				gridxy.gridy = 3;
				BookingPanel.add((Component) calendar,gridxy);
				
				
				
				// event PLACE label  and textfield
				eventPlace.setText("EVENT PLACE");
				gridxy.gridx = 0;
				gridxy.gridy = 4;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventPlace,gridxy);
				
				PlacePanel.setLayout(new GridBagLayout());
				PlacePanel.setBorder(BorderFactory.createTitledBorder("PLACE"));
				ButtonGroup placegroup = new ButtonGroup();
				
				eHall1.setText("Hall 1");
				eHall1.setSelected(true);
				placegroup.add(eHall1);
				gridxy.gridx = 0;
				gridxy.gridy = 0;
				gridxy.anchor = GridBagConstraints.WEST;	
				PlacePanel.add(eHall1,gridxy);
				eHall1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
					sizeButtonActionPerformed(e);
					}

					private void sizeButtonActionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						place = e.getActionCommand();
						
					}
					});
				
				eHall2.setText("Hall 2");
				eHall2.setSelected(true);
				placegroup.add(eHall2);
				gridxy.gridx = 0;
				gridxy.gridy = 1;
				gridxy.anchor = GridBagConstraints.WEST;	
				PlacePanel.add(eHall2,gridxy);
				eHall2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
					sizeButtonActionPerformed(e);
					}

					private void sizeButtonActionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						place = e.getActionCommand();
						
					}
					});
				
				
				gridxy.gridx = 1;
				gridxy.gridy = 4;
				BookingPanel.add(PlacePanel,gridxy);
				
				
				// event LIMIT label  and textfield
				eventlimit.setText("LIMIT");
				gridxy.gridx = 0;
				gridxy.gridy = 5;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventlimit,gridxy);
				
				//eLimit.setText("enter limit");
				eLimit.setColumns(15);
				eLimit.setHorizontalAlignment(SwingConstants.CENTER);
				eLimit.setEditable(true);
				//eLimit.setBackground(Color.gray);
				gridxy.gridx = 1;
				gridxy.gridy = 5;
				BookingPanel.add(eLimit, gridxy);
				
				
				
				// event ORGANIZER/DEPARTMENT label  and textfield
				eventcentre.setText("centre name");
				gridxy.gridx = 0;
				gridxy.gridy = 6;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventcentre,gridxy);
				
				//eDepartment.setText("enter department name");
				centreComboBox.setBackground(Color.WHITE);
				gridxy.gridx = 1;
				gridxy.gridy = 6;
				BookingPanel.add(centreComboBox, gridxy);
				gridxy.anchor = GridBagConstraints.NORTH; 
				BookingPanel.add(centreComboBox,gridxy);
				centreComboBox.addItem("School of international studies");
				centreComboBox.addItem("Centre for linguists");
				centreComboBox.addItem("School of life science");
				centreComboBox.addItem("Centre for european studies ");
				centreComboBox.addItem("School of Social Sciences");
				centreComboBox.setSelectedIndex(0);
				BookingPanel.add(centreComboBox, gridxy);
				
				
				
				// event DESCRIPTION label  and textfield
				eventdescription.setText("Add description");
				gridxy.gridx = 0;
				gridxy.gridy = 7;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(eventdescription,gridxy);
				
				//eDescription.setText("en");
				eDescription.setColumns(20);
				eDescription.setRows(6);
				//eDescription.setHorizontalAlignment(SwingConstants.CENTER);
				eDescription.setEditable(true);
			//	eDepartment.setBackground(Color.gray);
				gridxy.gridx = 1;
				gridxy.gridy = 7;
				BookingPanel.add(eDescription, gridxy);
				
				
				
				//booking button
				bookingButton.setText("BOOK");
				gridxy.gridx= 1;
				gridxy.gridy = 8;
				gridxy.insets = new Insets(5,0,5,0);
				BookingPanel.add(bookingButton,gridxy);
				bookingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bookingButtonActionPerformed(e);
					}
				});
//				
				
				
				// adding BOOKING panel to tabbed pane.
				EventPane.add("BOOKING" , BookingPanel);
				
				//**********************************************Booking tab end here********************************************************
				
				
		
				
				
				//**********************************************Login tab start here**********************************************************

				LoginPanel.setLayout(new GridBagLayout());
				LoginPanel.setBounds(20, 10, 1000, 600);
				
				//Login label
				loginLabel.setText("PLEASE LOGIN");
				gridxy.gridx = 1;
				gridxy.gridy = 0;
				gridxy.anchor = GridBagConstraints.CENTER;
				gridxy.insets = new Insets(10,10,0,0);
				LoginPanel.add(loginLabel,gridxy);
				
				
				//user login and combobox.
				userLabel.setText("user");
				gridxy.gridx = 0;
				gridxy.gridy = 1;
				gridxy.insets = new Insets(5,0,5,0);
				LoginPanel.add(userLabel,gridxy);
				
				userComboBox.setBackground(Color.WHITE);
				gridxy.gridx = 1;
				gridxy.gridy = 1;
				LoginPanel.add(userComboBox, gridxy);
				gridxy.anchor = GridBagConstraints.NORTH; 
				LoginPanel.add(userComboBox,gridxy);
				userComboBox.addItem("Student");
				userComboBox.addItem("Department");
				//userComboBox.addItem("Admin");
				userComboBox.setSelectedIndex(0);
				LoginPanel.add(userComboBox, gridxy);
				
				
				// USERNAME label and textfield
				usernameLabel.setText("USERNAME");
				gridxy.gridx = 0;
				gridxy.gridy = 2;
				gridxy.insets = new Insets(5,0,5,0);
				LoginPanel.add(usernameLabel,gridxy);
				
				username.setColumns(15);
				username.setHorizontalAlignment(SwingConstants.CENTER);
				username.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 2;
				LoginPanel.add(username, gridxy);
				
				
				// PASSWORD label and textfield
				passwordLabel.setText("PASSWORD");
				gridxy.gridx = 0;
				gridxy.gridy = 3;
				gridxy.insets = new Insets(5,0,5,0);
				LoginPanel.add(passwordLabel,gridxy);
				
				password.setColumns(15);
				password.setHorizontalAlignment(SwingConstants.CENTER);
				password.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 3;
				password.setEchoChar('*');
				LoginPanel.add(password, gridxy);
				
				loginButton.setText("LOGIN");
				gridxy.gridx = 1;
				gridxy.gridy = 4;
				gridxy.insets = new Insets(5,0,5,0);
				LoginPanel.add(loginButton,gridxy);
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					loginActionPerformed(e);
					}
					});
				
				EventPane.add("LOGIN" , LoginPanel);
				
				
				//******************************* login page ends here ******************************************************************
				
				
				
				
				
				
				//***********************************************student registration page start *****************************************8888
				
				RegistrationPanel.setLayout(new GridBagLayout());
				RegistrationPanel.setBounds(20, 10, 1000, 600);
				
				//Registration label
				registrationLabel.setText("STUDENT REGISTRATION PAGE");
				gridxy.gridx = 1;
				gridxy.gridy = 0;
				gridxy.anchor = GridBagConstraints.CENTER;
				gridxy.insets = new Insets(10,10,0,0);
				RegistrationPanel.add(registrationLabel,gridxy);
				
				
				//student REGISTRATION label and textfield
				studentRegistrationNo.setText("REGISTRATION NUMBER");
				gridxy.gridx = 0;
				gridxy.gridy = 1;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentRegistrationNo,gridxy);
				
				stud_registrationNo.setColumns(15);
				stud_registrationNo.setHorizontalAlignment(SwingConstants.CENTER);
				stud_registrationNo.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 1;
				RegistrationPanel.add(stud_registrationNo, gridxy);
				
				
				//student NAME label and textfield
				studentName.setText("NAME");
				gridxy.gridx = 0;
				gridxy.gridy = 2;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentName,gridxy);
				
	
				
				stud_name2.setColumns(15);
				stud_name2.setHorizontalAlignment(SwingConstants.CENTER);
				stud_name2.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 2;
				RegistrationPanel.add(stud_name2, gridxy);
				

				
				//student MOBILE_NO label and textfield
//				studentMobile.setText("PHONE NO.");
//				gridxy.gridx = 0;
//				gridxy.gridy = 3;
//				gridxy.insets = new Insets(5,0,5,0);
//				RegistrationPanel.add(studentMobile,gridxy);
//				
//				stud_mobile.setColumns(15);
//				stud_mobile.setHorizontalAlignment(SwingConstants.CENTER);
//				stud_mobile.setEditable(true);
//				gridxy.gridx = 1;
//				gridxy.gridy = 3;
//				RegistrationPanel.add(stud_mobile, gridxy);
				
				//student EMAIL label and textfield
				studentEmailId.setText("EMAIL ID");
				gridxy.gridx = 0;
				gridxy.gridy = 4;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentEmailId,gridxy);
				
				stud_email.setColumns(15);
				stud_email.setHorizontalAlignment(SwingConstants.CENTER);
				stud_email.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 4;
				RegistrationPanel.add(stud_email, gridxy);
				
				//student CENTRE/SCHOOL label and textfield
				studentCentre.setText("CENTRE/SCHOOL");
				gridxy.gridx = 0;
				gridxy.gridy = 5;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentCentre,gridxy);
				
				studentCentreComboBox.setBackground(Color.WHITE);
				gridxy.gridx = 1;
				gridxy.gridy = 5;
				RegistrationPanel.add(studentCentreComboBox, gridxy);
				gridxy.anchor = GridBagConstraints.NORTH; 
				RegistrationPanel.add(studentCentreComboBox,gridxy);
				studentCentreComboBox.addItem("School of international studies");
				studentCentreComboBox.addItem("Centre for linguists");
				studentCentreComboBox.addItem("School of life science");
				studentCentreComboBox.addItem("Centre for european studies ");
				studentCentreComboBox.addItem("School of Social Sciences");
				studentCentreComboBox.setSelectedIndex(0);
				RegistrationPanel.add(studentCentreComboBox, gridxy);
				
				//student USERNAME label and textfield
				studentUsername.setText("USERNAME");
				gridxy.gridx = 0;
				gridxy.gridy = 6;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentUsername,gridxy);
				
				stud_username.setColumns(15);
				stud_username.setHorizontalAlignment(SwingConstants.CENTER);
				stud_username.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 6;
				RegistrationPanel.add(stud_username, gridxy);
				
				
				//student PASSWORD label and textfield
				studentPassword.setText("PASSWORD");
				gridxy.gridx = 0;
				gridxy.gridy = 7;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studentPassword,gridxy);
				
				stud_password.setColumns(15);
				stud_password.setHorizontalAlignment(SwingConstants.CENTER);
				stud_password.setEditable(true);
				gridxy.gridx = 1;
				gridxy.gridy = 7;
				stud_password.setEchoChar('*');
				RegistrationPanel.add(stud_password, gridxy);
				
				
				
				// Student event label and JComboBox.
				
				studenteventLabel.setText("EVENTS");
				gridxy.gridx = 0;
				gridxy.gridy = 8;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(studenteventLabel,gridxy);
				
				eventComboBox.setBackground(Color.WHITE);
				gridxy.gridx = 1;
				gridxy.gridy = 8;
				RegistrationPanel.add(eventComboBox, gridxy);
				gridxy.anchor = GridBagConstraints.NORTH; 
				LoginPanel.add(eventComboBox,gridxy);
				eventComboBox.addItem("cultural fest");
				eventComboBox.addItem("workshop");
				eventComboBox.addItem("seminar");
				eventComboBox.addItem("DJ night");
				eventComboBox.addItem("Debate Competition");
				eventComboBox.setSelectedIndex(0);
				RegistrationPanel.add(eventComboBox, gridxy);
				
				
				// Registration button
				registerButton.setText("REGISTER");
				gridxy.gridx= 1 ;
				gridxy.gridy = 9;
				gridxy.insets = new Insets(5,0,5,0);
				RegistrationPanel.add(registerButton,gridxy);
				registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registerButtonActionPerformed(e);
					}
				});
				EventPane.add("REGISTRATION" , RegistrationPanel);
				
				pack();
				
		
		
		
	}
	
protected void signinButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource() == signinButton)
		EventPane.setSelectedIndex(3);
		
	}

//	private Container getContentPane() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	protected void signnuttonActionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource() == signinButton)
//			EventPane.setSelectedIndex(3);
//	}

	protected void bookingButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = eName.getText();
		int timeslot = timeComboBox.getSelectedIndex();
//		String month = (String) monthSpinner.getValue();
//		int monthNumber;
//		for(int i=0;i<12;i++) {
//			if(month == monthNames[i])
//				monthNumber = i;
//		}
//		int day = (int) daySpinner.getValue();
		String limit = eLimit.getText();
		int limitInt = Integer.parseInt(limit); 
		Object centre = centreComboBox.getSelectedItem();
	
		
			date1 = calendar.getDate();
		    sqlDate = new java.sql.Date(date1.getTime()); 
		

		
		
		try {
			
			String url =  "jdbc:mysql://localhost:3306/event_management";
			Connection con = DriverManager.getConnection(url, "root" , "himani@814");
			
			String query = "insert into event(eName,eTime,eDate,ePlace,eLimit,students) values(?,?,?,?,?,?) ";
			java.sql.PreparedStatement pstmt = con.prepareStatement(query);
			
			String time;
			pstmt.setString(1, name);
			if(timeslot == 0)
				time = "9:00 - 11:00";
			else if(timeslot == 1)
				time = "12:00 - 2:00";
			else if(timeslot == 2)
				time = "3:00 - 5:00";
			else
				time = "6:00 - 8:00";
			
			
			pstmt.setString(2, time);
			
			
			pstmt.setDate(3, sqlDate);
			
			
			pstmt.setString(4,place);
			pstmt.setInt(5, limitInt);
			pstmt.setInt(6,56);
			
			pstmt.execute();
			
			 
			String msg1 = "PLACE :  "  + place + "\n" + "Event :  " + name + "\n" + "CHARGES : 500RS.";
			JOptionPane.showConfirmDialog(null, msg1, "EVENT BOOKED", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);			
			
			
			
			con.close();
			
			
			
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null,exp);
		}
		
		
	}

	protected void registerButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String sname = stud_name.getText();
		String registrationNo = stud_registrationNo.getText();
	//	String mobile = stud_mobile.getText();
		String email = stud_email.getText();
		String centre = (String) studentCentreComboBox.getSelectedItem();
		String username = stud_username.getText();
		String password = stud_password.getText();
		String event = (String) eventComboBox.getSelectedItem();
		
		
		int registrationInt = Integer.parseInt(registrationNo);
		//int mobileInt = Integer.parseInt(mobile);
		
		try {
			
			String url =  "jdbc:mysql://localhost:3306/himanidb";
			Connection con = DriverManager.getConnection(url, "root" , "himani@814");
			
			//pstmt = con.createStatement();
			query = "select E_ID from event where eName = event";
			ResultSet resultSet = stmnt.executeQuery(query);
			int id = resultSet.getInt("E_ID");
			
			
			query = "insert into student(sRegistrationNo,sName,sPhoneNo,sEmail_ID,sCentre,sUsername,sPassword,sE_ID) values(?,?,?,?,?,?,?,?) ";
			java.sql.PreparedStatement pstmt = con.prepareStatement(query);
			//pstmt = con.createStatement();
			
			
			
			pstmt.setInt(1, registrationInt);
			pstmt.setString(2, sname);
			//pstmt.setInt(3,mobileInt);
			pstmt.setString(3,email);
			pstmt.setString(4,centre);
			pstmt.setString(5,username);
			pstmt.setString(6,password);
			pstmt.setInt(7,id);
			pstmt.execute();
			JOptionPane.showMessageDialog(null, "registered");			
			
			
			
			con.close();
			
			
			
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null,exp);
		}
		
		
	}

	protected void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object user =  userComboBox.getSelectedItem();
		if(user == "Student")
			EventPane.setSelectedIndex(4);
		else 
			EventPane.setSelectedIndex(2);
		
	}

	protected void dateStateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void EventDetailsButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		JFrame frame2 = new JFrame();
//		DefaultTableModel defaultTableModel;
//		int flag = 0;
		showDetails(e);
		//fetchData(e);
	}

	protected void OngoingButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ongoingButton) {
			//fetchData(e);
			showDetails(e);
		}
		
	}

	protected void UpcomingButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == upcomingButton) {
			//fetchData(e);
			showDetails(e);
		}
	}

	protected void exitButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	

	protected void EventPaneStateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	
	void showDetails(ActionEvent e) {
		defaultTableModel = new DefaultTableModel();
		table = new JTable(defaultTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(300,100));
		table.setFillsViewportHeight(true);
		frame2.add(new JScrollPane(table));
		defaultTableModel.addColumn("E_ID");
		defaultTableModel.addColumn("eName");
		defaultTableModel.addColumn("eTime");
		defaultTableModel.addColumn("eDate");
		defaultTableModel.addColumn("ePlace");
		defaultTableModel.addColumn("eLimit");
		
		
		try {
			String url = "jdbc:mysql://localhost:3306/event_management";
			connection  = DriverManager.getConnection(url,"root","himani@814");
			stmnt = connection.createStatement();
			if(e.getSource() == eventDetailsButton) 
				query = "select * from event";
			else if(e.getSource() == ongoingButton)
				query = "select * from event_management.event where eDate = '2022-08-16' ";
			else if(e.getSource() == upcomingButton)
				query = "SELECT * FROM event_management.event WHERE week(eDate) = week(now());";
				
			
			ResultSet resultSet = stmnt.executeQuery(query);
			
			if(resultSet.next() == false)
				JOptionPane.showMessageDialog(null, "no data item at present");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("E_ID");
				String name = resultSet.getString("eName");
				String time = resultSet.getString("eTime");
			    Date date = resultSet.getDate("eDate");
				String place = resultSet.getString("ePlace");
				int limit = resultSet.getInt("eLimit"); 
				int student = resultSet.getInt("students");
				
			    defaultTableModel.addRow(new Object[] {id,name,time,date,place,limit,student});
				frame2.setVisible(true);
				frame2.validate();
				frame2.setBounds(100,100,600,500);
				
						
			}		
					
			connection.close();
			
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
	}
	
	//Image getScaledImage(Image srcimg, int w, int h) {
		
	}

