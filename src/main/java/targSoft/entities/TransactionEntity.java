package targSoft.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    private String id;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "merchant")
    private String merchant;

    @Column(name = "type")
    private String type;

}
