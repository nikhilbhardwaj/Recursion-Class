#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// The method prototypes
void n_queens(int n);
void backtrack(vector<int>&, int current_row, int N);
bool construct_candidates(const vector<int>&, int row, int N, vector<int>&);
bool is_safe_square(const vector<int>&, int row, int col, int N);
bool is_solution(const vector<int>&, int N);
void print_solution(const vector<int>&, int N);

int main()
{
  int n;
  cin>>n;
  n_queens(n);
  return 0;
}

void n_queens(int n)
{
  vector<int> queens = vector<int>();
  backtrack(queens,0,n);
}

void backtrack(vector<int>& queens, int current_row, int N)
{
  // check if the configuration is solved
  if(is_solution(queens, N))
  {
    print_solution(queens,N);
  }
  else
  {
    // construct a vector of valid candidates
    vector<int> candidates = vector<int>();
    if(construct_candidates(queens,current_row,N,candidates))
    {
      for(int i=0; i < candidates.size(); ++i)
      {
        // Push this in the partial solution and move further
        queens.push_back(candidates[i]);
        backtrack(queens,current_row + 1,N);
        // If no feasible solution was found then we ought to remove this and try the next one
        queens.pop_back();
      }
    }
  }
}

bool construct_candidates(const vector<int>& queens, int row, int N, vector<int>& candidates)
{
  // Returns false if there are no possible candidates, we must follow a different
  // branch if this so happens
  for(int i=0; i<N; ++i)
  {
    if(is_safe_square(queens,row,i,N))
    {
      // Add a valid candidate, this can be done since we pass candidates by reference
      candidates.push_back(i);
    }
  }
  return candidates.size() > 0;
}

bool is_safe_square(const vector<int>& queens, int row, int col, int N)
{
  for(int i=0; i<queens.size(); ++i)
  {
    // case when the queens are already placed in the same row or column
    if(i == row || queens[i] == col) return false;
    // case when there is a diagonal threat
    // remember! y = mx + c for a diagonal m = 1 therefore |x2 - x1| = |y2 - y1|
    if(abs(i - row) == abs(queens[i] - col)) return false;
  }
  //Returns true when no unsafe square is found
  //handles the case when there are no queens on the board trivially
  return true;
}

bool is_solution(const vector<int>& queens, int N)
{
  return queens.size() == N;
}

void print_solution(const vector<int>& queens, int N)
{
  for(int i=0; i<N; ++i)
  {
    for(int j=0; j<N; ++j)
    {
      if(queens[i] == j){ cout<<'Q'; }
      else { cout<<'_'; }
    }
    cout<<endl;
  }
}
