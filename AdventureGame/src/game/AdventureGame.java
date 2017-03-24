package game;

import java.util.Scanner;

import hsa_new.Console;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * AdventureGame.java
 * @author Cole McMullin 
 * @author Mensimah Kwofie
 * Mon.,Feb.27,2017
 * 
 * This program is a text based choose your own adventure game. 
 * 
 */

public class AdventureGame {

	static Scanner in = new Scanner(System.in);

	static Console c = new Console(40,155);

	public static void main(String[] args) {
		boolean playAgain = false;
		//play background Music
		Clip backgroundMusic = null;
		try{
			backgroundMusic = AudioSystem.getClip();
			backgroundMusic.open(AudioSystem.getAudioInputStream(new File("Sounds/lavamud.wav")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

		do{
			//generate a random list of rooms
			int[] rooms = new int[9];
			for (int i = 0; i < 9; i++){
				rooms[i] = i+1;
			}
			//generate an array to keep track of the rooms that have already been visited
			int[] usedRooms = new int[9];
			
			
			//start of Game
			getImage(18);
			c.println("Welcome to the Marketplace! You are free to roam around and enjoy all precious jewels that we have.");
			c.println("What is your name?");
			String input = c.readLine();
			c.clear();
			getImage(18);
			c.println("Hello " + input + " Choose a character.");
			c.println("Knight; high strength, average intellegence & low dexterity");
			c.println("Witch; low strength, high intellegence & low dexterity");
			c.println("Civillian; low strength, low intellegence & low dexterity");
			c.println("Assasin; average strength, low intellegence & average dexterity");
			c.println("Thief; low strength, average intellegence & high dexterity");
			input = c.readLine();
			c.clear();
			getImage(6);
			c.println("While walking around the Marketplace, you get knocked out and kidnapped by two guards.");
			c.println("You wake up in an abandoned dungeon. Its now up to you to find your way out or at least die trying.");
			c.println("Good luck!");
			c.println("(hit any key and hit enter to continue)");
			String s = c.readLine();
			char character = input.toCharArray()[0];

			//get character's stats
			int str = getStr(character);
			int inte = getInt(character);
			int dex = getDex(character);
			boolean alive = true;
			boolean escaped = false;
			playAgain = false;
			int newRoom = 0;
			int roomCounter = 0;

			do{
				boolean unused = true;
				do{
					unused = true;
					newRoom = randomRoom();
					for (int i = 0; i < 9; i++){
						if(newRoom == usedRooms[i]){
							unused = false;
						}
					}
				}while(unused != true);

				usedRooms[roomCounter] = newRoom;
				roomCounter++;

				switch(newRoom){
				case 1: alive = room1(dex, str);
				continue;
				case 2: alive = room2(inte);
				continue;
				case 3: alive = room3(dex);
				continue;
				case 4: escaped = room4(inte);
				continue;
				case 5: escaped = room5();
				continue;
				case 6: escaped = room6(dex);
				continue;
				case 7: s = room7(dex, str, inte);
				if (s == "str"){
					str += 2;
					c.println("You manage to find a sword that isnt broken among the other garbage.");
					c.println("Your Strength increases by 2.");
				}

				else if (s == "dex"){
					dex += 2;
					c.println("There is an intact weapons case at the back of the room with a bow in it; Your lucky day.");
					c.println("Your Dexterity increases by 2.");
				}

				else{
					inte += 2;		
					c.println("At the back of the room under a rusted chestplate, you find a wand.");
					c.println("Your Intelligence increases by 2.");
				}

				continue;
				case 8: alive = room8(inte);
				continue;
				case 9: alive = room9(str);
				continue;
				}

			}while(alive == true && escaped == false);
			backgroundMusic.stop();
			c.println("Do you want to play again?");
			c.println("(Please type 'yes' or 'no' in lowercase letters and hit enter.)");
			String choice = c.readLine();
			if(choice.equals("yes")){
				playAgain = true;
				c.clear();
			}
			else{
				backgroundMusic.stop();
				c.close();
			}
		}while(playAgain == true);
	}

	//get a random room #
	public static int randomRoom(){
		return (int)((Math.random()*9)+1);
	}

	//Gets a random number from 1 to 6
	public static int randomNumber(){
		return (int)((Math.random()*6)+1);
	}

	//Dragon room
	public static boolean room1(int dex, int str){
		getImage(1);
		c.println("You enter a dimly lit hallway with a sleeping baby dragon in it.");
		c.println("It is sure to wake up if you make a lot of noise.");
		c.println("Do you want to sneak past it or try to fight it?");
		c.println("(Please type 'sneak' or 'fight' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if(choice.equals("sneak")){
			int dc = randomNumber() + dex;
			if (dc > 7){
				getImage(1);
				c.println("Congratulations you made it past the dragon without waking it up!");
				return true;
			}
			else{
				getImage(3);
				c.println("In your attempt to sneak past the dragon, you accidentally kick it.");
				c.println("At which point the dragon wakes up and burns you to death.");
				return false;
			}
		}
		else{
			c.println("You Attack!");
			int dc = randomNumber() + str;
			if (dc > 8){
				getImage(2);
				c.println("Your first slice kills the dragon and you leave the room.");
				c.println("As you exit you feel a twinge of sadness at the dragons death.");
				return true;
			}
			else{
				getImage(3);
				c.println("The dragon doesn't react kindly to you trying to stab it.");
				c.println("It wakes up and burns you alive."); 
				return false;
			}
		}
	}

	// Hallway
	public static boolean room2(int inte){
		getImage(4);
		c.println("You enter a hallway that seems a little to clean for an underground dungeon.");
		c.println("Would you like to search the hallway or carry on?");
		c.println("(Please type 'search' or 'carry on' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if (choice.equals("search")){
			int dc = randomNumber() + inte;
			if (dc > 6){
				c.println("You find a hidden arrow trap, triggered by pressure plates on the floor.");
				c.println("You skillfully avoid the trap and carry on with your day.");
				return true; 
			}
			else{
				getImage(5);
				c.println("While investigating the hallway, you get hit with an arrow.");
				c.println("You bleed out on the floor; your last minutes are spent thinking of your family.");
				return false;
			}
		}
		else{
			getImage(5);
			c.println("Walking across the room, you get hit in the skull with an arrow and die");
			return false;
		}
	}

	// Rock fall
	public static boolean room3(int dex){
		getImage(6);
		c.println("You enter a room that looks like it's about to crumble.");
		c.println("When you get to the middle of the room the ceiling caves in.");
		c.println("A rock comes hurdling straight towards you.");
		c.println("Would you like to duck or jump?");
		c.println("(Please type 'duck' or 'jump' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if (choice.equals("jump")){
			int dc = randomNumber() + dex;
			if (dc > 8){
				c.println("You narrowly avoid the rock but the floor collapses below your feet.");
				c.println("You fall into another room.");
				return true;
			}
			else{
				getImage(7);
				c.println("The rock smashes into your chest, crushing both of your lungs.");
				return false;
			}
		}
		else{
			getImage(7);
			c.println("You flatten yourself to the ground and the ceiling falls on you.");
			return false;
		}
	}

	// Secret door room
	public static boolean room4(int inte){
		getImage(8);
		c.println("You enter a room where the walls are very smooth with only one exit.");
		c.println("Would you like to search the room or carry on?");
		c.println("(Please type 'search' or 'carry on' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if (choice.equals("search")){
			int dc = randomNumber() + inte;
			if (dc > 9){
				room5();
				return true;
			}
			else{
				getImage(8);
				c.println("You find nothing and exit the room.");
				return false;
			}
		}
		else{
			getImage(8);
			c.println("This room seems normal enough, you walk swiftly out of the room.");
			return false;
		}
	}

	// Exit
	public static boolean room5(){
		getImage(18);
		c.println("Congratulations, you finally found an exit to the dungeon.");
		c.println("You make your way back to the Marketplace.");
		return true;
	}

	//Sneak past or fight guards
	public static boolean room6(int dex){
		getImage(9);
		c.println("You enter the beginning of what looks like a dimly lit series of twisting passages.");
		c.println("There are many guards patrolling and they look like the ones that kidnapped you earlier in the marketplace.");
		c.println("They must be guarding somthing important! If only there was a way past them.");
		c.println("There only seem to be a few guards.");
		c.println("Would you like to sneak past or fight the guards?");
		c.println("(Please type 'sneak' or 'fight' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if(choice.equals("sneak")){
			getImage(9);
			for (int i = 0; i <3; i++){ 
				int dc = randomNumber() + dex;
				if (dc > 7){
					c.println("There are more guards than you originally thought.");
					c.println("Would you like to continue trying to sneak past them?");
					c.println("(Please type 'yes' or 'no' in lowercase letters and hit enter");
					String answer = c.readLine();
					if (answer.equals("Yes")){
						continue;
					}
					else{
						getImage(10);
						c.println("Your indicision is costly:");
						c.println("as you decide to retreat a guard spots you and you are quickly surrounded but barely manage to escape through a side passage.");
						return false;
					}
				}
			}
			c.println("You succesfully sneak past the guards. Congratulations!");
			room5();
			return true;
		}
		else{
			getImage(10);
			c.println("You start a fight with the guards but the commotion and noise attracts attention.");
			c.println("Many more guards emerge from a hidden room and quickly overwhelm you but you manage to escape through a side passage.");
			return false; 
		}
	}




	// Choosing a Weapon
	public static String room7(int dex, int str, int inte){
		getImage(11);
		c.println("You enter a room that looks like it used to be an armoury before being abandoned.");
		c.println("There is alot of junk lying around.");
		c.println("There is probably somthing useful but, you would have to know what you're looking for");
		c.println("Pick a weapon to search for: bow, sword, or wand");
		c.println("(Please type 'sword', 'bow', or 'wand' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if (choice .equals("sword")){
			getImage(12);
			return "str";
		}
		else if (choice .equals("bow")){
			getImage(13);
			return "dex";
		}
		else{
			getImage(14);
			return "inte";
		}
	}

	//Ditch of thorns
	public static boolean room8(int inte){
		getImage(15);
		c.println("You enter a room with a ditch running across the middle of it.");
		c.println("The ditch is full of poisinous thorn bushes.");
		c.println("The ditch is very wide but there appears to be a small section that looks narrow enough to jump across.");
		c.println("Would you like to investigate the room further or jump across the narrow part of the ditch?");
		c.println("(Please type 'investigate' or 'jump' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if(choice.equals("investigate")){
			getImage(15);
			int dc = randomNumber() + inte;
			if (dc > 7){
				c.println("You found a way around the ditch without jumping and exit the room.");
				return true;
			}
			else{
				getImage(15);
				c.println("In your attempt to investigate the edges of the ditch you fall in.");
				c.println("The poisin quickly overwhelmes your immune system and you die in a matter of seconds.");
				return false;
			}
		}
		else{
			getImage(15);
			c.println("As you get ready to jump, the sides of the ditch crumble and you fall in.");
			c.println("The poisin quickly overwhelmes your immune system and you die in a matter of seconds.");
			return false;
		}

	}

	//Rock wall room
	public static boolean room9(int str){
		getImage(16);
		c.println("You enter a room with a rock wall leading up to an exit.");
		c.println("The rocks are smooth but climbing shouldnt be too difficult.");
		c.println("Would you like to climb or turn around?");
		c.println("(Please type 'climb' or 'turn' in lowercase letters and hit enter.)");
		String choice = c.readLine();
		c.clear();
		if (choice.equals("climb")){
			getImage(16);
			boolean climb = false;
			do{
				int dc = randomNumber() + str;
				if (dc > 5){
					c.println("You skillfully climb the rock wall and exit the room.");
					return true;
				}
				else{
					getImage(16);
					c.println("You slip on the smooth rock.");
					c.println("Would you like to continue to try to climb?");
					c.println("(Please type 'yes' or 'no' in lowercase letters and hit enter.)");
					choice = c.readLine();
					c.clear();
					climb = false;
					if(choice.equals("yes")){
						climb = true;
					}
					else{
						getImage(17);
						c.println("As you pick your way back down to the base of the cliff you slip.");
						c.println("You land hard on the ground and crack open your skull.");		
						c.println("You die almost instantly.");
						return false;
					}
				}
			}while(climb == true);
		}
		else{
			getImage(17);
			c.println("As you walk through the doorway you just came through the walls close in and crush you to death.");
			return false;
		}
		return true;
	}

	//method to get Strength
	public static int getStr(char character){
		switch(character){
		case 'K': return 9;
		case 'W': return 1;
		case 'C': return 2;
		case 'A': return 6;
		case 'T': return 1;
		}
		return 0;
	}

	//method to get Intelligence
	public static int getInt(char character){
		switch(character){
		case 'K': return 4;
		case 'W': return 9;
		case 'C': return 2;
		case 'A': return 2;
		case 'T': return 4;
		}
		return 0;
	}

	//method to get Dexterity
	public static int getDex(char character){
		switch(character){
		case 'K': return 2;
		case 'W': return 3;
		case 'C': return 2;
		case 'A': return 6;
		case 'T': return 9;
		}
		return 0;
	}

	//Method to display images
	public static void getImage(int i){
		switch(i){
		case 1: BufferedImage DragonSleeping= null;
		try {
			DragonSleeping = ImageIO.read(new File ("Images/DragonSleeping.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (DragonSleeping, 0, 0, 1250, 800, null);
		return;

		case 2: BufferedImage DeadDragon = null;
		try {
			DeadDragon = ImageIO.read(new File ("Images/DeadDragon.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (DeadDragon, 0, 0, 1250, 800, null); ;
		return;

		case 3: BufferedImage DragonBreathingFire = null;
		try {
			DragonBreathingFire = ImageIO.read(new File ("Images/DragonBreathingFire.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (DragonBreathingFire, 0, 0, 1250, 800, null); ; ;
		return;

		case 4: BufferedImage ArrowTrap = null;
		try {
			ArrowTrap = ImageIO.read(new File ("Images/ArrowTrap.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (ArrowTrap, 0, 0, 1250, 800, null); 
		return;

		case 5: BufferedImage DeadArrowPerson = null;
		try {
			DeadArrowPerson = ImageIO.read(new File ("Images/DeadArrowPerson.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (DeadArrowPerson, 0, 0, 1250, 800, null);
		return;

		case 6: BufferedImage CollapsingRoom = null;
		try {
			CollapsingRoom = ImageIO.read(new File ("Images/CollapsingRoom.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (CollapsingRoom, 0, 0, 1250, 800, null);
		return;

		case 7:BufferedImage RockFalling = null;
		try {
			RockFalling = ImageIO.read(new File ("Images/RockFalling.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (RockFalling, 0, 0, 1250, 800, null); 
		return;

		case 8: BufferedImage RoomWithOneExit = null;
		try {
			RoomWithOneExit = ImageIO.read(new File ("Images/RoomWithOneExit.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (RoomWithOneExit, 0, 0, 1250, 800, null);
		return;

		case 9:BufferedImage GuardedRoom = null;
		try {
			GuardedRoom = ImageIO.read(new File ("Images/GuardedRoom.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (GuardedRoom, 0, 0, 1250, 800, null); 
		return;

		case 10:BufferedImage CaughtByGaurds = null;
		try {
			CaughtByGaurds = ImageIO.read(new File ("Images/CaughtByGaurds.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (CaughtByGaurds, 0, 0, 1250, 800, null);
		return;

		case 11:BufferedImage ArmouryRoom = null;
		try {
			ArmouryRoom = ImageIO.read(new File ("Images/ArmouryRoom.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (ArmouryRoom, 0, 0, 1250, 800, null);
		return;

		case 12:BufferedImage Sword = null;
		try {
			Sword = ImageIO.read(new File ("Images/Sword.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (Sword, 0, 0, 1250, 800, null); 
		return;

		case 13:BufferedImage Bow = null;
		try {
			Bow = ImageIO.read(new File ("Images/Bow.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (Bow, 0, 0, 1250, 800, null);
		return;

		case 14:BufferedImage Wand = null;
		try {
			Wand = ImageIO.read(new File ("Images/Wand.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (Wand, 0, 0, 1250, 800, null);
		return;

		case 15:BufferedImage Throns = null;
		try {
			Throns = ImageIO.read(new File ("Images/Throns.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (Throns, 0, 0, 1250, 800, null); 
		return;

		case 16:BufferedImage RockWall = null;
		try {
			RockWall = ImageIO.read(new File ("Images/RockWall.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (RockWall, 0, 0, 1250, 800, null);
		return;

		case 17:BufferedImage PersonFalling = null;
		try {
			PersonFalling = ImageIO.read(new File ("Images/PersonFalling.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (PersonFalling, 0, 0, 1250, 800, null);
		return;

		case 18:BufferedImage Marketplace = null;
		try {
			Marketplace = ImageIO.read(new File ("Images/Marketplace.gif"));
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		} 
		c.drawImage (Marketplace, 0, 0, 1250, 800, null); 
		return;
		}
	}
}
