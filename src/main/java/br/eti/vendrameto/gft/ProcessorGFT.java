/**
 *
 */
package br.eti.vendrameto.gft;

/**
 * @author developer
 *
 */
public class ProcessorGFT {

	private final String DISH_TYPE_MORNING = "morning";
	private final String DISH_TYPE_NIGHT = "night";

	private String[] parametros = null;

	/**
	 * Valida parâmetros de entrada
	 */
	public String processa(String entradaDeDados) {
		if (entradaDeDados.contains(",")) {
			parametros = entradaDeDados.split(",");
		} else {
			// Esse item não foi especificados
			return "parâmetros de entrada invalida!";
		}

		if (!DISH_TYPE_MORNING.equalsIgnoreCase(parametros[0]) && !DISH_TYPE_NIGHT.equalsIgnoreCase(parametros[0])) {
			// Esse item não foi especificados
			return "Dish type invalida!";
		}

		Dish dish = new Dish();
		switch (parametros[0]) {
		case DISH_TYPE_MORNING:
			dish.setType(DISH_TYPE_MORNING);
			dish.setEntree(new Food("eggs"));
			dish.setSide(new Food("toast"));
			dish.setDrink(new Food("coffee", false));
			break;
		case DISH_TYPE_NIGHT:
			dish.setType(DISH_TYPE_NIGHT);
			dish.setEntree(new Food("steak"));
			dish.setSide(new Food("potato", false));
			dish.setDrink(new Food("wine"));
			dish.setDessert(new Food("cake"));
			break;
		}

		boolean hasError = false;
		for (int i = 1; i < parametros.length; i++) {
			boolean valid = false;
			switch (parametros[i].trim()) {
			case "1":
				valid = validarItem(dish.getEntree(), dish.getCountEntree());
				if (valid) {
					dish.incrementCountEntree();
				}
				break;
			case "2":
				valid = validarItem(dish.getSide(), dish.getCountSide());
				if (valid) {
					dish.incrementCountSide();
				}
				break;
			case "3":
				valid = validarItem(dish.getDrink(), dish.getCountDrink());
				if (valid) {
					dish.incrementCountDrink();
				}
				break;
			case "4":
				valid = validarItem(dish.getDessert(), dish.getCountDessert());
				if (valid) {
					dish.incrementCountDessert();
				}
				break;
			}

			if (!valid) {
				hasError = true;
				break;
			}
		}

		return dish.toString() + ((hasError) ? ", error" : "");
	}

	private boolean validarItem(Food food, int count) {
		if (food == null) {
			// Sem comida definida
			return false;
		}

		if (food.isLimit() && count > 0) {
			// Ja atingiu o limite
			return false;
		}

		return true;
	}

}

class Dish {
	private String type;
	private Food entree;
	private Food side;
	private Food drink;
	private Food dessert;
	private int countEntree = 0;
	private int countSide = 0;
	private int countDrink = 0;
	private int countDessert = 0;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Food getEntree() {
		return entree;
	}

	public void setEntree(Food entree) {
		this.entree = entree;
	}

	public Food getSide() {
		return side;
	}

	public void setSide(Food side) {
		this.side = side;
	}

	public Food getDrink() {
		return drink;
	}

	public void setDrink(Food drink) {
		this.drink = drink;
	}

	public Food getDessert() {
		return dessert;
	}

	public void setDessert(Food dessert) {
		this.dessert = dessert;
	}

	public int getCountEntree() {
		return countEntree;
	}

	public int getCountSide() {
		return countSide;
	}

	public int getCountDrink() {
		return countDrink;
	}

	public int getCountDessert() {
		return countDessert;
	}

	public void incrementCountEntree() {
		this.countEntree++;
	}

	public void incrementCountSide() {
		this.countSide++;
	}

	public void incrementCountDrink() {
		this.countDrink++;
	}

	public void incrementCountDessert() {
		this.countDessert++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		toStringItem(sb, this.getEntree(), this.getCountEntree());
		toStringItem(sb, this.getSide(), this.getCountSide());
		toStringItem(sb, this.getDrink(), this.getCountDrink());
		toStringItem(sb, this.getDessert(), this.getCountDessert());

		return sb.toString();
	}

	private void toStringItem(StringBuilder sb, Food food, int count) {
		if (food != null && count > 0) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			sb.append(food.getName());
			if (count > 1) {
				sb.append("(x");
				sb.append(count);
				sb.append(")");
			}
		}
	}

}

class Food {
	private String name;
	private boolean limit;

	public Food(String name) {
		this(name, true);
	}

	public Food(String name, boolean limit) {
		this.name = name;
		this.limit = limit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLimit() {
		return limit;
	}

	public void setLimit(boolean limit) {
		this.limit = limit;
	}

}
