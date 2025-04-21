#include <iostream>
#include <vector>
#include <string>
#include <stdexcept>

using namespace std;

// Custom exception class for book unavailability
class BookUnavailableException : public runtime_error {
public:
    BookUnavailableException(const string& message) : runtime_error(message) {}
};

class Book {
private:
    int bookID;
    string title;
    int quantity;

public:
    // Constructor
    Book(int id, const string& t, int qty) : bookID(id), title(t), quantity(qty) {
        if (qty < 0) {
            throw invalid_argument("Book quantity cannot be negative.");
        }
    }

    // Getter methods
    int getBookID() const { return bookID; }
    string getTitle() const { return title; }
    int getQuantity() const { return quantity; }

    // Setter method for quantity (with validation)
    void setQuantity(int qty) {
        if (qty < 0) {
            throw invalid_argument("Book quantity cannot be negative.");
        }
        quantity = qty;
    }

    // Overload the + operator to add book quantities
    Book operator+(const Book& other) const {
        return Book(bookID, title, quantity + other.quantity);
    }

    // Overload the < operator to compare book quantities
    bool operator<(const Book& other) const {
        return quantity < other.quantity;
    }

    // Overload the > operator to compare book quantities
    bool operator>(const Book& other) const {
        return quantity > other.quantity;
    }

    // Display book information
    void display() const {
        cout << "Book ID: " << bookID << endl;
        cout << "Title: " << title << endl;
        cout << "Quantity: " << quantity << endl;
    }
};

class Library {
private:
    vector<Book> inventory;

public:
    // Add a book to the inventory
    void addBook(const Book& book) {
        // Check if the book already exists (by ID)
        for (auto& b : inventory) {
            if (b.getBookID() == book.getBookID()) {
                b = b + book; // Use overloaded + to add quantities
                cout << "Book with ID " << book.getBookID() << " already exists. Quantity updated." << endl;
                return;
            }
        }
        inventory.push_back(book);
        cout << "Book added to inventory." << endl;
    }

    // Borrow a book
    void borrowBook(int bookID) {
        for (auto& book : inventory) {
            if (book.getBookID() == bookID) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    cout << "Book with ID " << bookID << " borrowed successfully." << endl;
                    return;
                } else {
                    throw BookUnavailableException("Book with ID " + to_string(bookID) + " is currently out of stock.");
                }
            }
        }
        cout << "Book with ID " << bookID << " not found in inventory." << endl;
    }

    // Display available books
    void displayAvailableBooks() const {
        if (inventory.empty()) {
            cout << "Inventory is empty." << endl;
            return;
        }
        cout << "\n--- Available Books ---" << endl;
        for (const auto& book : inventory) {
            book.display();
            cout << "-----------------------" << endl;
        }
    }
};

int main() {
    Library library;
    int choice;

    do {
        cout << "\n--- Library Management System ---" << endl;
        cout << "1. Add Books to Inventory" << endl;
        cout << "2. Borrow a Book" << endl;
        cout << "3. Display Available Books" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int id, qty;
                string title;
                cout << "Enter Book ID: ";
                cin >> id;
                cout << "Enter Book Title: ";
                cin.ignore(); // Consume the newline character left by cin >> int
                getline(cin, title);
                cout << "Enter Book Quantity: ";
                cin >> qty;
                try {
                    Book newBook(id, title, qty);
                    library.addBook(newBook);
                } catch (const invalid_argument& e) {
                    cerr << "Error: " << e.what() << endl;
                }
                break;
            }
            case 2: {
                int id;
                cout << "Enter Book ID to borrow: ";
                cin >> id;
                try {
                    library.borrowBook(id);
                } catch (const BookUnavailableException& e) {
                    cerr << "Error: " << e.what() << endl;
                }
                break;
            }
            case 3: {
                library.displayAvailableBooks();
                break;
            }
            case 4: {
                cout << "Exiting the Library Management System. Goodbye!" << endl;
                break;
            }
            default: {
                cout << "Invalid choice. Please try again." << endl;
            }
        }
    } while (choice != 4);

    return 0;
}
