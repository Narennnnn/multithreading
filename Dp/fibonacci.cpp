#include<iostream>
#include<vector>
#include<cstring>  // For memset
using namespace std;
vector<int> dp; 
int fibonacci(int n) {
    if (n <= 1)
        return 1;
    if (dp[n] != -1)
        return dp[n];
    return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    int n;
    cin >> n;
    
    dp.resize(n + 1, -1);  
    
    cout << fibonacci(n) << endl; 
}
