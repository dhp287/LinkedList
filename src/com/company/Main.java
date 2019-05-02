package com.company;
import java.util.Scanner;

public class Main {

    Node head = null;
    Node tail = null;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Main m = new Main();
        boolean cont = true;
        while (cont){
            System.out.println("1. Append an item.");
            System.out.println("2. Remove from end.");
            System.out.println("3. Remove greater than target.");
            System.out.println("4. Display the list.");
            System.out.println("5. Exit.");
            System.out.print("Enter an option: ");
            int option = scr.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter a number to add in the list.");
                    int num = scr.nextInt();
                    m.append(new Node(num));
                    break;
                case 2:
                    m.remove();
                    break;
                case 3:
                    System.out.println("Enter a target number.");
                    int target = scr.nextInt();
                    m.removeGreater(target);
                case 4:
                    m.display();
                    break;
                case 5:
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    public void append(Node node){
        if(head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void remove(){
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            Node curr = head;
            while (curr.next != tail){
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
    }

    public void removeGreater(int target){
        if(head == tail && head.data > target){
            head = null;
            tail = null;
        }
        else {
            Node prev = head;
            Node curr = head.next;
            while (curr != null){
                if(curr.data > target){
                    prev.next = curr.next;
                    if(curr == tail){
                        tail = prev;
                    }
                    curr = curr.next;
                }
                else{
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            if(head.data > target){
                head = head.next;
            }
        }
    }

    public void display(){
        Node curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}