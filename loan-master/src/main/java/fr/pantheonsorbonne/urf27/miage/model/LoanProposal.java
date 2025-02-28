package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;


@Entity
public class LoanProposal {

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoanSimulation", nullable = false)
    private Long idLoanSimulation;

    @OneToOne(optional = false) //Une LoanSimulation concerne un dossier
    @JoinColumn(name = "idDossier", nullable = false)
    private Dossier dossier;

    @Column(name = "dateSimulation", nullable = false)
    private Instant dateSimulation;

    @Column(name = "interestRate", nullable = false)
    private double interestRate; // En %

    @Column(name = "duration", nullable = false)
    private int loanDuration; //Exprimé en mois.

    @Column(name = "monthlyRefund", nullable = false)
    private double monthlyRefund; //Montant du remboursement de chaque mois.

    @Column(name = "debtRate", nullable = false) //Il existe aussi le taux endettement (généralement 33% en france).
    private double debtRate; // En %

    @Column(name = "dateEnd", nullable = false)
    private Instant dateEnd;

    @OneToOne(optional = false) //Une LoanSimulation concerne un un seul employé de banque.
    @JoinColumn(name = "idOfficer", nullable = false)
    private Officer officer;

    /*Constructeurs de la classe LoanProposal */

    public LoanProposal(Dossier dossier,double interestRate, int loanDuration, double monthlyRefund, double debtRate, Instant dateEnd, Officer officer) {
        this.dossier = dossier;
        //this.dateSimulation = dateSimulation; ici mettre la date du jour, voir comment faire sr instant
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.monthlyRefund = monthlyRefund;
        this.debtRate = debtRate;
        this.dateEnd = dateEnd;
        this.officer = officer;
    }

    public LoanProposal() {
        
    }
}
