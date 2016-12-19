#include <iostream>
#include <string>
#include <iomanip>

using namespace std;


class User {

private:
	string accountName;
	int accountNumber;
	double totBalance;
	int pinNumber;
	char accType;

public:

	void setAccName(string accountName) {
		this->accountName = accountName;
	}

	string getAccName() {
		return accountName;
	}

	void setAccNumber(int accountNumber) {
		this->accountNumber = accountNumber;
	}

	int getAccNumber() {
		return accountNumber;
	}

	void setBalance(double totBalance) {
		this->totBalance = totBalance;
	}

	double getBalance() {
		return totBalance;
	}

	void setPinNumber(int pinNumber) {
		this->pinNumber = pinNumber;
	}

	int getPinNumber() {
		return pinNumber;
	}

	void setAccType(char accType) {
		this->accType = accType;
	}

	char getAccType() {
		return accType;
	}

	double deposit(double tot) {
		totBalance += tot;
		return totBalance;
	}

	double withdraw(double tot) {
		totBalance -= tot;
		return totBalance;
	}

	void AccountInformation() {
		cout << endl << "Account Name : " << getAccName() << endl;
		cout << "Account Number : " << getAccNumber() << endl;
		cout << "Account Type : " << getAccType() << endl;
	}

	void modifyInformation() {
		int choose;
		cout << endl << "Choose from below sub menu" << endl;
		cout << "1 For Account name" << endl;
		cout << "2 For Account pin number" << endl;
		cout << "3 Account type" << endl;
		string name;
		int pin;
		char type;
		cin >> choose;

		switch (choose) {
		case 1:
			cout << "Old account name : " << getAccName();
			cout << "Enter new account name : ";
			cin >> name;
			setAccName(name);
			cout << "Name changed" << endl;
			break;
		case 2:
			cout << "Enter new pin : ";
			cin >> pin;
			setPinNumber(pin);
			cout << "Pin changed" << endl;
			break;
		case 3:
			cout << "Old account type : " << getAccType();
			cout << "Enter new account type : ";
			cin >> type;
			setAccType(type);
			cout << "Account type changed" << endl;
			break;
		default: cout << "Invalid option";
			break;
		}

	}

};

void addAccount(User *U);
void modifyAccount(User *U);

int main() {
	char c;
	string username = "admin", password = "welcome", un, pwd;
	int choice, totalAccounts = 0, accNumberCheck, pinCheck, flag1 = 0;
	double bal;
	User* accHolder = new User[5];
	bool userCheck;

	do {
	label1:
		cout << endl << "Enter U for user" << endl << "Enter B for bank employee" << endl;
		cout << "Enter Y for exit" << endl;
		cin >> c;
		if (c == 'U') {
			if (totalAccounts != 0) {
				cout << "Type your account number : ";
				cin >> accNumberCheck;
				cout << "Type unique pin number : ";
				cin >> pinCheck;
				for (int i = 0; i < totalAccounts; i++) {
					if (accNumberCheck == (accHolder[i].getAccNumber()) && (pinCheck == accHolder[i].getPinNumber())) {
						userCheck = false;
						flag1 = i;
						break;
					}
					else {
						userCheck = true;
					}
				}
				if (userCheck) {
					cout << endl << "Account not in records" << endl;
					goto label1;
				}
				while (c == 'U' && userCheck == false) {
					cout << endl << "Choose from below menu" << endl;
					cout << "1 : Account Information" << endl;
					cout << "2 : Modify Account" << endl;
					cout << "3 : Deposit" << endl;
					cout << "4 : Withdraw" << endl;
					cout << "5 : Balance Enquiry" << endl;
					cout << "6 : Exit" << endl;

					cin >> choice;
					switch (choice) {
					case 1: accHolder[flag1].AccountInformation();
						break;
					case 2: accHolder[flag1].modifyInformation();
						break;
					case 3: cout << endl << "Enter amount to deposit : ";
						cin >> bal;
						accHolder[flag1].deposit(bal);
						cout << endl << "Deposit complete" << endl;
						break;
					case 4: cout << endl << "Enter amount to withdraw : ";
						cin >> bal;
						accHolder[flag1].withdraw(bal);
						cout << endl << "Withdrawel complete" << endl;
						break;
					case 5: cout << endl << "Total balance : " << accHolder[flag1].getBalance() << endl;
						break;
					case 6:
						c = 'E';
						break;
					default: cout << endl << "Invalid option";
						break;
					}
				}
			}
			else {
				cout << endl << "No records found. Check with your bank please.";
			}
		}
		while (c == 'B') {
			cout << "Username : ";
			cin >> un;
			cout << "Password : ";
			cin >> pwd;
			if (username == un && password == pwd)
				goto label2;
			else {
				cout << "Invalid username or password" << endl;
				break;
			}
		label2:
			cout << endl << "Choose from below menu" << endl;
			cout << "1 : Add Account" << endl;
			cout << "2 : Modify Account" << endl;
			cout << "3 : Delete Account" << endl;
			cout << "4 : Get All Accounts" << endl;
			cout << "5 : Exit" << endl;
			cin >> choice;
			switch (choice)
			{
			case 1:
				if (totalAccounts < 5) {
					addAccount(&accHolder[totalAccounts]);
					totalAccounts++;
					goto label2;
				}
				else {
					cout << endl << "No more space for new record. Delete existing record" << endl;
					goto label2;
				}
				break;
			case 2:
				cout << endl << "Please type account number to modify : ";
				cin >> accNumberCheck;
				for (int i = 0; i < totalAccounts; i++) {
					if (accNumberCheck == accHolder[i].getAccNumber()) {
						userCheck = false;
						modifyAccount(&accHolder[i]);
						break;
					}
					else
						userCheck = true;
				}
				if (userCheck) {
					cout << endl << "Account not in records";
					goto label2;
				}
				goto label2;
				break;
			case 3:
				cout << endl << "Please type account number to delete : ";
				cin >> accNumberCheck;
				for (int i = 0; i < totalAccounts; i++) {
					if (accNumberCheck == accHolder[i].getAccNumber()) {
						userCheck = false;
						User temp;
						temp = accHolder[totalAccounts - 1];
						accHolder[totalAccounts - 1] = accHolder[i];
						accHolder[i] = temp;
						totalAccounts--;
						cout << "Account deleted successfully" << endl;
						break;
					}
					else
						userCheck = true;
				}
				if (userCheck) {
					cout << endl << "Account not in records";
					goto label2;
				}
				goto label2;
				break;
			case 4:
				cout << endl << "----------------------------------------------" << endl;
				cout << setw(10) << "| Name" << setw(10) << "| Acc Number" << setw(10) << "| Acc Type" << setw(10) << "| Balance" << "|" << endl;
				cout << "----------------------------------------------" << endl;
				for (int i = 0; i < totalAccounts; i++) {
					cout << endl;
					cout << setw(10) << accHolder[i].getAccName();
					cout << setw(10) << accHolder[i].getAccNumber();
					cout << setw(10) << accHolder[i].getAccType();
					cout << setw(10) << accHolder[i].getBalance() << ".00" << endl;
				}
				cout << "----------------------------------------------" << endl;
				goto label2;
				break;
			case 5:
				c = 'E';
				break;
			default:
				cout << "Invalid selection";
				goto label2;
				break;
			}
		}
	} while (c != 'Y');

	delete[] accHolder;
	return 0;
}

void addAccount(User *U) {
	string accountName;
	int accountNumber;
	double totBalance;
	int pinNumber;
	char accType;

	cout << endl << "Enter name of the account holder : ";
	cin >> accountName;
	U->setAccName(accountName);

	cout << endl << "Enter the account number : ";
	cin >> accountNumber;
	U->setAccNumber(accountNumber);

	cout << endl << "Enter pin number : ";
	cin >> pinNumber;
	U->setPinNumber(pinNumber);

	cout << endl << "Enter initial balance : ";
	cin >> totBalance;
	U->setBalance(totBalance);

	cout << endl << "Enter account type : ";
	cin >> accType;
	U->setAccType(accType);
}

void modifyAccount(User *U) {

	string accountName;
	int choice;
	char accType;
	double bal;

	cout << endl << "Choose from below sub menu" << endl;
	cout << endl << "1 : Change Account Name" << endl;
	cout << "2 : Change Account Type" << endl;
	cout << "3 : Deposit" << endl;
	cout << "4 : Withdraw" << endl;
	cin >> choice;
	switch (choice) {
	case 1:
		cout << endl << "Old account name : " << U->getAccName() << endl;
		cout << endl << "New account name : ";
		cin >> accountName;
		U->setAccName(accountName);
		cout << "Account Name changed successfully" << endl;
		break;

	case 2:
		cout << endl << "Old account type : " << U->getAccType() << endl;
		cout << endl << "New account type : ";
		cin >> accType;
		U->setAccType(accType);
		cout << "Account type changed successfully";
		break;
	case 3:
		cout << "Enter amount to deposit : ";
		cin >> bal;
		U->deposit(bal);
		cout << "Amount deposited successfully";
		break;
	case 4:
		cout << "Enter amount to withdraw : ";
		cin >> bal;
		U->withdraw(bal);
		cout << "Amount withdrawn successfully";
		break;
	default:
		cout << "Invalid option";
		break;
	}
}