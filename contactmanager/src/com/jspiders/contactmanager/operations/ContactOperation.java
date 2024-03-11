package com.jspiders.contactmanager.operations;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.contactmanager.entity.Contact;
import com.jspiders.contactmanager.main.ContactMain;

public class ContactOperation {
	static ArrayList<Contact> contacts = new ArrayList<>();

	public static void addContact(Scanner scanner) {
		System.out.println("Enter Id");
		int id = 0;
		boolean Idcheck = false;
		while (!Idcheck) {
			try {
				id = scanner.nextInt();
				Idcheck = true;

			} catch (Exception e) {
				System.err.println("Enter Valid Id!!!!!!!!");
				scanner.nextLine();
			}
		}
		scanner.nextLine();
		System.out.println("Enter First Name");
		String FirstName = scanner.nextLine();
		System.out.println("Enter Last Name");
		String LastName = scanner.nextLine();
		System.out.println("Enter mobile Number");
		long MobileNumber = 0;
		long validMob = 0;
		boolean checkMobile = false;
		while (!checkMobile) {
			try {
				validMob = scanner.nextLong();
				checkMobile = true;
			} catch (Exception e) {
				System.err.println("Enter Valid Mobile Number!!!!!!!!");
				scanner.nextLine();
			}
		}
		int length = String.valueOf(validMob).length();
		boolean MobCheck = true;
		while (MobCheck) {
			if (length == 10) {
				MobileNumber = validMob;
				MobCheck = false;
			} else {
				System.err.println("Enter valid 10-digit Mobile Number!!!!!");
				boolean Check = true;
				while (Check) {
					try {
						validMob = scanner.nextLong();
						Check = false;
					} catch (Exception e) {
						System.err.println("Enter Valid Mobile Number!!!!!!!!");
						scanner.nextLine();
					}
				}
				length = String.valueOf(validMob).length();
			}
		}
		scanner.nextLine();
		System.out.println("Enter Email Id");
		String email = scanner.nextLine();
		System.out.println("Enter category");
		String Category = getCategory();
		Contact contact = new Contact(id, FirstName, LastName, MobileNumber, email, Category);
		contacts.add(contact);
		System.out.println("\u001B[32mContact Created Successfully\u001B[0m");
	}

	private static String getCategory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Family\n2.Friend\n3.collegue");
		int choice = 0;
		boolean checkChoice = true;
		while (checkChoice) {
			try {
				choice = scanner.nextInt();
				checkChoice = false;
			} catch (Exception e) {
				System.err.println("Enter Valid Choice");
				scanner.nextLine();
			}
		}
		String Category = null;
		switch (choice) {
		case 1:
			Category = "Family";

			break;
		case 2:
			Category = "Friend";
			break;
		case 3:
			Category = "Collegue";
			break;

		default:
			System.err.println("Enter valid category");
			getCategory();
			break;
		}

		return Category;
	}

	public static void deleteContact() {
		viewContacts();
		System.out.println("Enter The Id to delete contact!!");
		Scanner scanner = new Scanner(System.in);
		int id=0;
		boolean condition=true;
		while (condition) {
			try {
				id = scanner.nextInt();
				condition=false;
			} catch (Exception e) {
				System.err.println("Enter Valid Choice");
				scanner.nextLine();
			} 
		}
		Contact ContactToBeDeleted = null;
		for (Contact contact : contacts) {
			if (contact.getId() == id) {
				ContactToBeDeleted = contact;
				break;
			} else {
				System.err.println("This contact is not present");
			}
		}
		contacts.remove(ContactToBeDeleted);
		System.err.println("Contact Deleted successfully");
		scanner.nextLine();
	

	}

	public static void viewContacts() {
		boolean check = contacts.isEmpty();
		if (check == true) {
			System.err.println("Contact List is Empty");
		} else {
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}

	}

	public static void searchContact() {
		boolean check = contacts.isEmpty();

		if (check == true) {
			System.err.println("Contact List is Empty!!!!");

		} else {
			Scanner scanner = new Scanner(System.in);
			int choice = 0;
			System.out.println("Search By??????");
			System.out.println("1.Id\n2.First Name\n3.Last Name\n4.Mobile Number\n5.Email\n6.Category");
			boolean Idcheck = true;
			while (Idcheck) {
				try {
					choice = scanner.nextInt();
					Idcheck = false;
				} catch (Exception e) {
					System.err.println("Enter Valid search Option");
					scanner.nextLine();
				}
			}
			switch (choice) {
			case 1:
				System.out.println("Enter Id");
				int Nid = 0;
				try {
					Nid = scanner.nextInt();
				} catch (Exception e) {
					System.err.println("Enter Valid Id");
					break;
				}
				for (Contact contact : contacts) {
					if (contact.getId() == Nid) {
						System.out.println(contact);
					} else {
						System.err.println("This contact is not present");
					}
				}
				break;
			case 2:
				System.out.println("Enter First Name");
				scanner.nextLine();
				String NFirstName = scanner.nextLine();
				for (Contact contact : contacts) {
					if (contact.getFirstName().equals(NFirstName)) {
						System.out.println(contact);
					} else {
						System.err.println("This contact is not present");
						break;
					}

				}
				break;
			case 3:
				System.out.println("Enter Last Name");
				scanner.nextLine();
				String NLastName = scanner.nextLine();
				for (Contact contact : contacts) {
					if (contact.getLastName().equals(NLastName)) {
						System.out.println(contact);
					} else {
						System.err.println("This contact is not present");
						break;
					}
				}
				break;
			case 4:
				System.out.println("Enter Mobile Number");
				
				long NMobileNumber=0;
				boolean condition=true;
				while (condition) {
					try {
						NMobileNumber = scanner.nextLong();
						condition=false;
					} catch (Exception e) {
						System.err.println("Enter Valid Mobile number.");
						scanner.nextLine();
					} 
				}
				for (Contact contact : contacts) {
					if (contact.getMobileNumber() == NMobileNumber) {
						System.out.println(contact);
					} else {
						System.err.println("This contact is not present");
						break;
					}
				}
				break;
			case 5:
				System.out.println("Enter Email Id");
				scanner.nextLine();
				String NEmail = scanner.nextLine();
				for (Contact contact : contacts) {
					if (contact.getEmail().equals(NEmail)) {
						System.out.println(contact);
					} else {
						System.err.println("This contact is not present");
						break;
					}
				}
				break;
			case 6:
				System.out.println("Choose category");
				System.out.println("1.Family\n2.Friend\n3.Collegue");
				int choice1 = 0;
				
				boolean checkCat = true;
				while (checkCat) {
					try {
						choice1 = scanner.nextInt();
						checkCat = false;

					} catch (Exception e) {
						System.err.println("Enter Valid Category");
//						break;
						scanner.nextLine();

					}
				}
				switch (choice1) {
				case 1:
					for (Contact contact : contacts) {
						if (contact.getCategory() == "Family") {
							System.out.println(contact);
							break;
						}
						else {
							System.err.println("This contact is not present");	
							break;
						}
					}

					break;
				case 2:
					for (Contact contact : contacts) {
						if (contact.getCategory() == "Friend") {
							System.out.println(contact);
							break;
						}
						else {
							System.err.println("This contact is not present");
							break;
						}
					}

					break;
				case 3:
					for (Contact contact : contacts) {
						if (contact.getCategory() == "Collegue") {
							System.out.println(contact);
							break;
						}
						else {
							System.err.println("This contact is not present");
							break;
						}
					}
					break;
				default:
					System.err.println("This contact is not present");
					break;
				}
				break;
			default:
				System.err.println("Enter Valid Choice");
				searchContact();
				break;

			}

		}
	}

	

	public static void editContacts() {
		viewContacts();
		System.out.println("Enter Id");
		Scanner scanner = new Scanner(System.in);
		int id = 0;
		boolean check1 = true;
		while (check1) {
			try {
				id = scanner.nextInt();
				check1 = false;
			} catch (Exception e) {
				System.err.println("Enter Valid Input");
				scanner.nextLine();
			}
		}
		for (Contact contact : contacts) {
			if (contact.getId() == id) {
				int choice = editMenu(contact);
				switch (choice) {
				case 1:
					System.out.println("Enter Updated Name");
					scanner.nextLine();
					String NewName = scanner.nextLine();
					contact.setFirstName(NewName);
					System.out.println("\u001B[32mName updated successfully!!! \u001B[0m");
					break;
				case 2:
					System.out.println("Enter Updated Last Name");
					scanner.nextLine();
					String NewLastName = scanner.nextLine();
					contact.setLastName(NewLastName);
					System.out.println("\u001B[32mLast Name updated successfully!!! \u001B[0m");

					break;
				case 3:
					System.out.println("Enter Updated Mobile Number");
					scanner.nextLine();
					long MobileNumber = 0;
					long validMob = 0;
					boolean checkMobile = false;
					while (!checkMobile) {
						try {
							validMob = scanner.nextLong();
							checkMobile = true;
							break;
						} catch (Exception e) {
							System.err.println("Enter Valid Mobile Number!!!!!!!!");
							scanner.nextLine();
						}
					}
					int length = String.valueOf(validMob).length();
					boolean MobCheck = true;
					while (MobCheck) {
						if (length == 10) {
							 contact.setMobileNumber(validMob);
							MobCheck = false;
						} else {
							System.err.println("Enter valid 10-digit Mobile Number!!!!!");
							boolean Check = true;
							while (Check) {
								try {
									validMob = scanner.nextLong();
									Check = false;
								} catch (Exception e) {
									System.err.println("Enter Valid Mobile Number!!!!!!!!");
									scanner.nextLine();
								}
							}
							length = String.valueOf(validMob).length();
						}
					}
					System.out.println("\u001B[32mMobile Number updated successfully!!!\u001B[0m");
					break;
				case 4:
					System.out.println("Enter Updated Email");
					scanner.nextLine();
					String NewEmail = scanner.nextLine();
					contact.setEmail(NewEmail);
					System.out.println("\u001B[32mEmail updated successfully!!!\u001B[0m");
					editMenu(contact);
					break;
				case 5:
					System.out.println("Select New Ctaegory");
					System.out.println("1.Family\n2.Friend\n3.Collegue");
					int choice1 = 0;
					boolean check = true;
					while (check) {
						try {
							choice1 = scanner.nextInt();
							check = false;
						} catch (Exception e) {
							System.err.println("Enter Valid Input");
							scanner.nextLine();
						}
					}
					switch (choice1) {
					case 1:
						contact.setCategory("Family");
						System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
						break;
					case 2:
						contact.setCategory("Friend");
						System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
						break;
					case 3:
						contact.setCategory("Collegue");
						System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
						break;
					default:
						System.err.println("Enter Valid Input");
						break;
					}
					break;
				default:
					System.err.println("Enter valid choice!!");
					break;
				}
			} else {
				System.err.println("This Contact is not present");
				break;
			}
		}

	}
	public static int editMenu(Contact contact) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter What you want to change.");
		System.out.println("1.First Name:" + contact.getFirstName());
		System.out.println("2.Last Name:" + contact.getLastName());
		System.out.println("3.Mobile Number:" + contact.getMobileNumber());
		System.out.println("4.Email:" + contact.getEmail());
		System.out.println("5.Category:" + contact.getCategory());
		int choice = 0;
		boolean check = true;
		while (check) {
			try {
				choice = scanner.nextInt();
				check = false;
			} catch (Exception e) {
				System.err.println("Enter valid Input");
				scanner.nextLine();
			}
		}
		return choice;

	}
}
