package view;

import entity.Critic;
import entity.Critic;
import java.util.List;

public class CriticView {

	public void displayCritic(Critic critic){
		System.out.println(critic);
	}
	public void displayCritics(List<Critic> critics){
		for(Critic critic:critics){
			System.out.println(critic);
		}
	}

}
