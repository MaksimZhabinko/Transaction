package targSoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionAvgDto {
    private List<TransactionDto> transactionDtos;
    private Double avg;
}
