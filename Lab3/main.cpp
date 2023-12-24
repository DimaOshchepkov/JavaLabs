#include <iostream>
#include <vector>
#include <cstring>

void printMatrix(std::vector<std::vector<int>> matrix);

std::vector<int> Сount(std::string word) {
    std::vector<int> count(2, 0);
    for (char c : word) {
        if (c == '0') {
            count[0]++;
        } else {
            count[1]++;
        }
    }
    return count;
}

int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

long long C(int n, int k) {
    // Base Cases
    if (k == 0 || k == n) {
        return 1;
    }
    // C(n, k) = C(n-1, k-1) + C(n-1, k)
    return C(n - 1, k - 1) + C(n - 1, k);
}

int getSerialNumber(std::string word) {
    std::vector<int> count = Сount(word);
    int n = word.length();
    int serialNumber = 0;
    char letters[n + 1];
    strcpy(letters, word.c_str());

    for (int i = 0; i < n; i++) {
        if (letters[i] == '1') {
            if (count[0] > 0) {
                serialNumber += C(count[0] + count[1] - 1, count[0] - 1);
            }
            count[1] -= 1;
        } else {
            count[0] -= 1;
        }
    }

    return serialNumber;
}

std::string getWord(int serialNumber, int totalPlaces, int onesPlaces) {
    std::string word = "";

    for (int i = 0; i < totalPlaces; i++) {
        if (totalPlaces - i == onesPlaces) {
            word += "1";
            onesPlaces--;
            continue;
        }

        int possibleCombinations = C(totalPlaces - i - 1, onesPlaces);
        if (serialNumber < possibleCombinations) {
            word += "0";
        } else {
            word += "1";
            onesPlaces--;
            serialNumber -= possibleCombinations;
        }
    }

    return word;
}

std::vector<int> getSerialNumbers(std::string word) {
    std::vector<int> serialNumbers;

    std::vector<int> numbers;
    for (char c : word) {
        int n = c - '0';
        numbers.push_back(n);
    }

    int lengths[] = {14, 9, 6, 4};
    std::vector<std::vector<int>> matrix;

    for (int i = 0; i < 4; ++i) {
        std::vector<int> row;
        for (int j = 0; j < 14; j++) {
            if (numbers[j] >= 0) {
                if (numbers[j] == 0) {
                    row.push_back(0);
                } else {
                    row.push_back(1);
                }
                numbers[j] -= 1;
            }
        }
        matrix.push_back(row);
    }

    printMatrix(matrix);

    int serialNumberArray[4];
    for (int i = 0; i < 4; ++i) {
        std::string line = "";
        for (int el : matrix[i]) {
            line += std::to_string(el);
        }
        serialNumberArray[i] = getSerialNumber(line);
        serialNumbers.push_back(serialNumberArray[i]);
    }

    return serialNumbers;
}

std::string getWordFromSerialNumbers(std::vector<int> serialNumbers) {
    int lengths[] = {14, 9, 6, 4};
    std::vector<std::string> words = std::vector<std::string>(4);

    words[0] = getWord(serialNumbers[0], 14, 9);
    words[1] = getWord(serialNumbers[1], 9, 6);
    words[2] = getWord(serialNumbers[2], 6, 4);
    words[3] = getWord(serialNumbers[3], 4, 1);

    int i1 = 0, i2 = 0, i3 = 0;
    int word[14] = {0};

    for (int i = 0; i < 14; ++i) {
        if (words[0][i] == '1') {
            word[i] += 1;
            if (words[1][i1] == '1') {
                word[i] += 1;

                if (words[2][i2] == '1') {
                    word[i] += 1;

                    if (words[3][i3] == '1') {
                        word[i] += 1;
                    }
                    i3++;
                }
                i2++;
            }
            i1++;
        }
    }

    std::string answer = "";
    for (int i : word) {
        answer += std::to_string(i);
    }
    return answer;
}

void printMatrix(std::vector<std::vector<int>> matrix) {
    for (std::vector<int> line : matrix) {
        for (int el : line) {
            std::cout << el << " ";
        }
        std::cout << std::endl;
    }
}

int main() {
    std::string word;
    std::cout << "Enter a word: " << std::endl;
    std::cin >> word;

    std::vector<int> serialNumbers = getSerialNumbers(word);
    std::cout << "Serial numbers of the word: ";
    for (int i : serialNumbers) {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    std::string newWord = getWordFromSerialNumbers(serialNumbers);
    std::cout << "The word obtained from its serial numbers: " << newWord << std::endl;

    return 0;
}
