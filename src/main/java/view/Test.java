/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import model.Liga;

/**
 *
 * @author z003ywys
 */
public class Test {
     public static void main(String args[]){ 
            System.out.println("Test");
            MainView mv2 = new MainView();
            MainController m2 = new MainController(mv2, new Liga("Liga 1"));
    }
}
