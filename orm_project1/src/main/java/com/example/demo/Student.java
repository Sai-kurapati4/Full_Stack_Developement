	package com.example.demo;

	import jakarta.persistence.*;

	@Entity
	@Table(name = "details")
	public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    @Override
	    public String toString() {
	        return "Student [id=" + id + ", name=" + name + "]";
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

	}
