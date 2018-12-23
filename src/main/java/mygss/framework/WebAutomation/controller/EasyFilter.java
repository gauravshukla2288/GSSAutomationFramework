package mygss.framework.WebAutomation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EasyFilter {

	static enum Operator {
		EQUALS, EQUALS_IGNORE_CASE, LT, GT, OR, AND, ENDS_WITH, STARTS_WITH, NOT, ISNULL, CONTAINS,
		CONTAINS_IGNORE_CASE;
	}

	private String name;

	private Object[] values;

	private EasyFilter left;

	private EasyFilter right;

	private Operator operator;

	public String getName() {
		return name;
	}

	// Consturctors
	public EasyFilter(String name, Object[] values, Operator operator) {
		this.name = name;
		this.values = values;
		this.operator = operator;
	}

	public EasyFilter(EasyFilter left, EasyFilter right, Operator operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	// public EasyFilter(String name, Object value, Operator operator) {
	// this(name, new Object[]{value}, operator);
	// }

	public static EasyFilter equals(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.EQUALS);
	}

	public static EasyFilter equalsIgnoreCase(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.EQUALS_IGNORE_CASE);
	}

	public static EasyFilter lt(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.LT);
	}

	public static EasyFilter gt(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.GT);
	}

	public static EasyFilter endsWith(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.ENDS_WITH);
	}

	public static EasyFilter startsWith(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.STARTS_WITH);
	}

	public static EasyFilter contains(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.CONTAINS);
	}

	public static EasyFilter containsIgnoreCase(String name, String value) {
		return new EasyFilter(name, new Object[] { value }, Operator.CONTAINS_IGNORE_CASE);
	}

	public static EasyFilter isNull(String name) {
		return new EasyFilter(name, new Object[] { null }, Operator.ISNULL);
	}

	/////
	public static EasyFilter not(EasyFilter exp) {
		return new EasyFilter(null, exp, Operator.NOT);
	}

	public static EasyFilter or(EasyFilter left, EasyFilter right) {
		return new EasyFilter(left, right, Operator.OR);
	}

	public static EasyFilter and(EasyFilter left, EasyFilter right) {
		return new EasyFilter(left, right, Operator.AND);
	}

	@SuppressWarnings("incomplete-switch")
	public boolean match(EasyFilter filter, Map<String, Object> parameters) {
		String name = filter.name;
		Object[] values = filter.values;
		Operator operator = filter.operator;
		EasyFilter left = filter.left;
		EasyFilter right = filter.right;

		// Value in the Map
		Object currentValue = parameters.get(name);

		if (parameters.containsKey(name)) {
			return false;
		} else if (operator.equals(Operator.AND)) {
			return left.match(parameters) && right.match(parameters);
		} else if (operator.equals(Operator.OR)) {
			return left.match(parameters) || right.match(parameters);
		} else if (operator.equals(Operator.NOT)) {
			return !right.match(parameters);
		} else if (operator.equals(Operator.AND)) {
			return left.match(parameters) && right.match(parameters);
		} else if (operator.equals(Operator.ISNULL)) {
			return (currentValue == null);
		}
		// if values are null
		else if ((operator.equals(Operator.EQUALS) || operator.equals(Operator.EQUALS_IGNORE_CASE))
				&& ((values == null) || (values.length == 1 && values[0] == null))) {
			return currentValue == null;
		}

		else if (operator.equals(Operator.EQUALS)) {
			if (currentValue.getClass().isArray() && !values[0].getClass().isArray()) {
				currentValue = ((Object[]) currentValue)[0];
			}
			return currentValue.equals(values[0]);
		}

		else if (operator.equals(Operator.EQUALS_IGNORE_CASE)) {
			if (currentValue.getClass().isArray() && !values[0].getClass().isArray()) {
				currentValue = ((Object[]) currentValue)[0];
			}
			return currentValue.toString().toLowerCase().equals(values[0].toString().toLowerCase());
		}

		else if (values == null || values[0] == null) {

			throw new RuntimeException("Null values not supported for Filter");
		}

		else if (values[0] instanceof String) {
			if (currentValue.getClass().isArray())
				currentValue = ((Object[]) currentValue)[0];
			switch (operator) {
			case CONTAINS:
				return currentValue.toString().contains(values[0].toString());

			case CONTAINS_IGNORE_CASE:
				return currentValue.toString().toLowerCase().contains(values[0].toString().toLowerCase());

			case STARTS_WITH:
				return currentValue.toString().toLowerCase().startsWith(values[0].toString().toLowerCase());

			case ENDS_WITH:
				return currentValue.toString().toLowerCase().endsWith(values[0].toString().toLowerCase());

			}
		} else if (values[0] instanceof Number) {

			if (currentValue.getClass().isArray())
				currentValue = ((Object[]) currentValue)[0];

			BigDecimal mapValue = new BigDecimal(currentValue.toString());
			BigDecimal filterValue = new BigDecimal(values[0].toString());

			switch (operator) {
			case LT:
				return mapValue.compareTo(filterValue) == -1;
			case GT:
				return mapValue.compareTo(filterValue) == 1;
			default:
				break;
			}
		}
		throw new RuntimeException("Should not reach here in Filter");

	}

	public boolean match(Map<String, Object> parameters) {
		Map<String, Object> parameters2 = new HashMap<String, Object>();
		for (Entry<String, Object> entry : parameters.entrySet()) {
			parameters2.put(entry.getKey(), entry.getValue());
		}
		return match(this, parameters2);
	}

	// getter and Setter

	public void setName(String name) {
		this.name = name;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}

	public EasyFilter getLeft() {
		return left;
	}

	public void setLeft(EasyFilter left) {
		this.left = left;
	}

	public EasyFilter getRight() {
		return right;
	}

	public void setRight(EasyFilter right) {
		this.right = right;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
