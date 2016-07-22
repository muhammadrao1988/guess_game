package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Do You Want to play game?");
        System.out.println("Press Y for yes N for no.");
        char play_game = input.next().charAt(0);

        int trial_version_usage = 1;//for trial use when program run
        int trial_time = 3;// trial period
        int user_credit = 0;// after trial period user credit will check
        char play_again = 'n';//for confirmation message want to play or not
        char purchase_credit = 'n';// for confirmation message want to purchase credit or not
        boolean purchased = false;//after trial user purchase credit or not


        if(play_game=='Y' || play_game=='y'){
            int random_number = random.nextInt(10) +1;
            do {
                System.out.println("Please enter any number between 1 to 10");
                int user_number = input.nextInt();
                if(user_number==random_number){
                    System.out.println("Congratulations you have won");
                }else{
                    System.out.println("You Lost...");
                }
                // when trial period end or user credit zero  after purchase
                if((trial_version_usage >=trial_time && purchased==false )|| (user_credit == 0 && purchased==true)){

                    if(purchased==false) {//show message when trial end
                        System.out.println("You trial period has completed");
                    }
                    if(user_credit == 0 && purchased==true){//show message when trial end and purchase credit end
                        System.out.println("Your credit has been finished...");
                    }

                    play_again = 'n';

                    System.out.println();
                    System.out.println("Do you want to add credit? Press Y for yes N for no.");
                    purchase_credit = input.next().charAt(0);

                    if(purchase_credit=='y' || purchase_credit=='Y') {
                        System.out.println("Please enter credit from 1 to 5");
                        user_credit = input.nextInt();
                        if (user_credit > 5 || user_credit == 0) {
                            System.out.println("invalid credit. Please try again");
                        }else{
                            purchased =true;
                            play_again='y';
                        }
                    }


                }else {

                    System.out.println();
                    System.out.println("Do you want to play again?");
                    System.out.println("Press Y for yes N for no.");
                    play_again = input.next().charAt(0);
                }
                trial_version_usage++;//count number of trial attempt

                if(purchased==true){
                    user_credit--;//credit deduct after purchase credit
                }



            }while (play_again=='Y' || play_again=='y');



        }else{
            System.out.println("Thank you for using game");
        }




    }
}
