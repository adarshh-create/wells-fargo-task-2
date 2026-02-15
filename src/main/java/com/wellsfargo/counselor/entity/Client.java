package com.wellsfargo.counselor.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;
    private String phone;

    // Each client has exactly one portfolio
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    protected Client() {}

    public Client(Long clientId,
                  FinancialAdvisor advisor,
                  String firstName,
                  String lastName,
                  String email,
                  String phone,
                  Portfolio portfolio) {
        this.clientId = clientId;
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.portfolio = portfolio;
    }

    public Long getClientId() { return clientId; }

    public FinancialAdvisor getAdvisor() { return advisor; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
