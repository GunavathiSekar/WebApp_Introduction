class Employee {

    private int id;
    private String name;
    private String dept;
    private String salary;

    Employee(int id,String name,String dept,String salary){
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + name + dept + salary;
    }
}