package com.easportz.tictactoe;


// Den här klassen representerar en ruta.
public class Block implements Drawable{

	// marker pekar på spelaren som har markerat rutan.
	private Player marker = null;
	
	
	// draw ritar rutan i terminalen.
	public void draw() {
		// TODO Auto-generated method stub
		if (marker != null)
			System.out.print(marker.getStatus());
		else
			System.out.print("-");
	}

	public Player getMarker() {
		return marker;
	}

	public void setMarker(Player marker) {
		this.marker = marker;
	}
	
	// Vi overridar den här metoden för att kunna bestämma om två rutor har markerats av samma spelare eller inte. 
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if (obj != null) {
			Block p2 = ((Block)obj);
			// vi kollar först om ingen av rutorna inte är tom.
			if (!this.isEmpty() && !p2.isEmpty() && this.getMarker().getStatus() == p2.getMarker().getStatus()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public boolean isEmpty() {
		if (getMarker() == null) {
			return true;
		}else {
			return false;
		}
	}
	

}
