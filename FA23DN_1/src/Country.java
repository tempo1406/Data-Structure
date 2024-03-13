import java.util.Objects;

public class Country implements Comparable<Country> {
	public int code;
	public int rank;
	public String name;

	public Country() {
	}

	public Country(int code, int rank, String name) {
		this.code = code;
		this.rank = rank;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, rank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return code == other.code && Objects.equals(name, other.name) && Objects.equals(rank, other.rank);
	}

	@Override
	public int compareTo(Country o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", rank=" + rank + ", name=" + name + "]";
	}

}
