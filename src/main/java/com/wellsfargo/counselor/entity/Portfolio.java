package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    // Enforce "each client has one portfolio" by making client_id unique
    @OneToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private String portfolioName;

    // Portfolio can contain 0..many securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioSecurity> securities = new ArrayList<>();

    protected Portfolio() {}

    public Portfolio(Long portfolioId,
                     Client client,
                     String portfolioName,
                     List<PortfolioSecurity> securities) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.portfolioName = portfolioName;
        this.securities = (securities != null) ? securities : new ArrayList<>();
    }

    public Long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public List<PortfolioSecurity> getSecurities() { return securities; }
    public void setSecurities(List<PortfolioSecurity> securities) {
        this.securities = (securities != null) ? securities : new ArrayList<>();
    }
}
