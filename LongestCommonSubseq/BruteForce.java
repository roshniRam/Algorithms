import java.util.Scanner;
class BruteForce{
  public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    String s1 = s.nextLine();
    String s2 = s.nextLine();

    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    subsequence(X,Y);
  }

  public static void subsequence(char[] a,char[] b){
      int index[]=new int[Math.min(a.length,b.length)];
      char commonChar[]=new char[Math.min(a.length,b.length)];
      int count1=0;
      for(int i=0;i<a.length;i++){
        for(int j=0;j<b.length;j++){
          if(a[i]==b[j]){
            if(count1==0){
              index[count1]=j;
              commonChar[count1]=b[j];
              count1++;
            }else{
              if(index[count1-1]<j){
                index[count1]=j;
                commonChar[count1]=b[j];
                count1++;
              }
            }
          }
        }
      }

      for(int i=0;i<commonChar.length;i++){
        System.out.print(commonChar[i]);
      }

      System.out.print("\n");
      int count2=0;
      for(int i=0;i<b.length;i++){
        for(int j=0;j<a.length;j++){
          if(a[j]==b[i] ){
            if(count2==0){
              index[count2]=j;
              commonChar[count2]=a[j];
              count2++;
              break;
            }else{
              if(index[count2-1]<j){
                index[count2]=j;
                commonChar[count2]=a[j];
                count2++;
                break;
              }
            }
          }
        }
      }
      for(int i=0;i<commonChar.length;i++){
        System.out.print(commonChar[i]);
      }

      if(count1<count2){
        System.out.println("\nThe longest common subsequence is of length "+count2);
      }else{
        System.out.println("\nThe longest common subsequence is of length "+count1);
      }
  }
}
