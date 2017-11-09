package hello;

import hello.Mapper.SalesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.Mapper.SalesMapper;

@Repository
@Slf4j
public class SalesRecordRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Get the ads_id, ads_url and ads_fontColor
     */

    public SalesRecord  getSalesRecord(String sales_person) {
            final String sql ="SELECT * FROM db_example.sales_record where sales_person=?";
        try {
            return jdbcTemplate.queryForObject(sql,new SalesMapper(),sales_person);
        } catch (Exception ex) {
            log.info("No sales record found.", ex);
            return null;
        }
    }

}
