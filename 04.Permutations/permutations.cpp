#include<iostream>
#include<string>

using namespace std;

void RecursivelyPermute(string soFar, string rest)
{
  if(rest == "")
  {
    cout<<soFar<<endl;
  }
  else
  {
    for( int i = 0; i < rest.length(); ++i)
    {
      string next = soFar + rest[i];
      string remaining = rest.substr(0,i) + rest.substr(i+1);
      RecursivelyPermute(next,remaining);
    }
  }
}

int main(int argc, char *argv[])
{
  RecursivelyPermute("",string(argv[1]));
  return 0;
}
