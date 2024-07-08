package com.ldev.opulator.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Opule {
	String timestamp;
	double probability;
	String opinion;

	public Opule(String timestamp, double probability, String opinion) {
		this.timestamp = timestamp;
		this.probability = probability;
		this.opinion = opinion;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(opinion, probability, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opule other = (Opule) obj;
		return Objects.equals(opinion, other.opinion)
				&& Double.doubleToLongBits(probability) == Double.doubleToLongBits(other.probability)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "PriceRecord [timestamp=" + timestamp + ", probability=" + probability + ", opinion=" + opinion + "]";
	}

	public Map<String, Object> toJson() {
		final Map<String, Object> json = new HashMap<String, Object>();
		json.put("probability", this.probability);
		json.put("timestamp", this.timestamp);
		json.put("opinion", this.opinion);

		return json;
	}

}
