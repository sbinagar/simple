#include <iostream>
#include <vector>
using namespace std;

class Book {
private:
    // Attributes here book id cant be negative
    unsigned int bookID; 
    string title;
    unsigned int quantity; 

public:
    
    Book() : bookID(0), title(""), quantity(0) {}

    // Parameterized constructor
    Book(unsigned int id, string t, unsigned int q) : bookID(id), title(t), quantity(q) {}

    // to set values from user
    void setdata() {
        cout << "Enter book ID: ";
        cin >> bookID;
        cin.ignore(); // Clear the newline character from the buffer
        cout << "Enter book title: ";
        getline(cin, title);
        cout << "Enter book quantity: ";
        cin >> quantity;
    }

    // Get value
    void getdata() const {
        cout << "Book ID: " << bookID << endl;
        cout << "Book Title: " << title << endl;
        cout << "Available Quantity: " << quantity << endl;
    }

    //  borrow and decrease quatntity
    void borrow(int num) {
        if (num > quantity) {
            cout << num << " books are not available currently. Only " << quantity << " books are available." << endl;
        } else {
            quantity -= num;
            cout << num << " books borrowed successfully. Remaining quantity: " << quantity << endl;
        }
    }

    // Getter for book ID private 
    unsigned int getBookID() const {
        return bookID;
    }

    // Getter for quantity private
    unsigned int getQuantity() const {
        return quantity;
    }
};

int main() {
    vector<Book> books; // using Vector to store books
    int choice;

    cout << "welcome to the library" << endl;
//menu drivcen switch 
    do {
        cout << "\nenter Choice" << endl;
        cout << "1. Add a new book" << endl;
        cout << "2. Display all books" << endl;
        cout << "3. Borrow a book" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                Book newBook;
                newBook.setdata();
                books.push_back(newBook);
                cout << "Book added successfully!" << endl;
                break;
            }
            case 2: {
                if (books.empty()) {
                    cout << "No books available in the library." << endl;
                } else {
                    cout << "\nAvailable Books:" << endl;
                    for (const auto& book : books) {
                        book.getdata();
                        cout << "-------------------" << endl;
                    }
                }
                break;
            }
            case 3: {
                if (books.empty()) {
                    cout << "No books available to borrow." << endl;
                } else {
                    unsigned int id, num;
                    cout << "Enter the book ID you want to borrow: ";
                    cin >> id;
                    cout << "Enter the number of books to borrow: ";
                    cin >> num;

                    bool found = false;
                    for (auto& book : books) {
                        if (book.getBookID() == id) {
                            if (book.getQuantity() >= num) {
                                book.borrow(num);
                            } else {
                                cout << "Not enough books available. Only " << book.getQuantity() << " books are available." << endl;
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        cout << "Book with ID " << id << " not found." << endl;
                    }
                }
                break;
            }
            case 4: {
                cout << " Thank you " << endl;
                break;
            }
            default: {
                cout << "Invalid choice. Please try again." << endl;
                break;
            }
        }
    } while (choice != 4);

    return 0;
}

