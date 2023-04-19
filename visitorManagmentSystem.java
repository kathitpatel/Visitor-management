import java.util.*;
import java.io.*;


/*************************** MENU OF VMS ****************************/

class MainMenu
{
  public void menu()
  {
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t  visitor MANAGEMENT SYSTEM");
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\t\t\t        Kathit patel ");
    System.out.println("\t\t\t    --------------------");
    System.out.println("\n\nPress 1 : To Add an visitor Details");
    System.out.println("Press 2 : To See an visitor Details ");
    System.out.println("Press 3 : To Remove an visitor");
    System.out.println("Press 4 : To Update visitor Details");
    System.out.println("Press 5 : To Exit ");

  }
}

/************************ To add details of visitor *********************/

class visitor_Add
{
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        visitorDetail emp=new visitorDetail();
        emp.getInfo();
        try{
            File f1=new File("file"+emp.visitor_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+emp.visitor_id+".txt");
                myWriter.write("visitor ID:"+emp.visitor_id+"\n"+"visitor Name     :"+emp.name+"\n"+
                "visitor Contact  :"+emp.visitor_contact+"\n"+
                "Email Information :"+emp.email+"\n"+"visit department :"+emp.department+"\n"+
                "visitor time   :"+emp.visitor_time);
                myWriter.close();
                System.out.println("\nvisitor has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nvisitor already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}

/************************* Taking visitor Details ************************/

class visitorDetail
{
    String name;
    String email;
    String department;
    String visitor_id;
    String visitor_time;
    String visitor_contact;
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter visitor's name --------: ");
        name=sc.nextLine();
        System.out.print("Enter visitor's ID ----------: ");
        visitor_id=sc.nextLine();
        System.out.print("Enter visitor's Email ID ----: ");
        email=sc.nextLine();
        System.out.print("Enter visit department ----: ");
        department=sc.nextLine();
        System.out.print("Enter visitor's contact Info --: ");
        visitor_contact=sc.nextLine();
        System.out.print("Enter visit time ------: ");
        visitor_time=sc.nextLine();
    }
}

/************************ To Show details of visitor *********************/

class visitor_Show
{
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    try (Scanner sc = new Scanner(file)) {
      while (sc.hasNextLine())
       {
         System.out.println(sc.nextLine());
       }
    }
   }
}

/***************************** To Remove visitor *************************/

class visitor_Remove
{
    public void removeFile(String ID)
    {

    File file = new File("file"+ID+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nvisitor has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nvisitor does not exists :( ");
       }
     }
}

/************************ To Update details of visitor ********************/

class visitor_Update
{
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   try (Scanner sc = new Scanner(file)) {
    String fileContext="";
     while (sc.hasNextLine())
         {
           fileContext =fileContext+"\n"+sc.nextLine();
         }
     FileWriter myWriter = new FileWriter("file"+s+".txt");
     fileContext = fileContext.replaceAll(o,n);
     myWriter.write(fileContext);
     myWriter.close();
  }

  }
}


/************************ To Exit *********************/

class CodeExit
{
  public void out()
  {
    System.out.println("\n*****************************************");
    System.out.println(" Thank You :) ");
    System.out.println("*****************************************");
    System.out.println("\t\t/~ <code by Kathit Patel\n");
    System.exit(0);
  }
}


/***************************** Main Class *******************************/
class visitorManagementSystem
{
  public static void main(String arv[])
  {
    /** To clear the output Screen **/
    System.out.print("\033[H\033[2J");

    Scanner sc=new Scanner(System.in);
    visitor_Show epv =new visitor_Show();

    int i=0;

    /*** Callining Mainmenu Class function ****/
    MainMenu obj1 = new MainMenu();
    obj1.menu();

    /*** Initialising loop for Menu Choices ***/
    while(i<6)
    {

      System.out.print("\nPlease Enter choice :");
      i=Integer.parseInt(sc.nextLine());

      /** Switch Case Statements **/
      switch(i)
      {
        case 1:
        {
        /** Creating class's object and calling Function using that object **/
        visitor_Add ep =new visitor_Add();
        ep.createFile();

        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
        }
        case 2:
        {
          System.out.print("\nPlease Enter visitor's ID :");
          String s=sc.nextLine();
          try
          {
            epv.viewFile(s);}
            catch(Exception e){System.out.println(e);}


            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }

        case 3:
        {
          System.out.print("\nPlease Enter visitor's ID :");
          String s=sc.nextLine();
          visitor_Remove epr =new visitor_Remove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4:
        {
            System.out.print("\nPlease Enter visitor's ID :");
            String I=sc.nextLine();
            try
            {
              epv.viewFile(I);
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
            visitor_Update epu = new visitor_Update();
            System.out.print("Please Enter the detail you want to Update :");
    	      System.out.print("\nFor Example :\n");
            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
            String s=sc.nextLine();
            System.out.print("Please Enter the Updated Info :");
            String n=sc.nextLine();
            try
            {
              epu.updateFile(I,s,n);

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              System.out.print("\033[H\033[2J");
              obj1.menu();
              break;
            }
            catch(IOException e)
            {
              System.out.println(e);
            }
        }
        case 5:
        {
          CodeExit obj = new CodeExit();
          obj.out();
        }
      }
    }
  }
}