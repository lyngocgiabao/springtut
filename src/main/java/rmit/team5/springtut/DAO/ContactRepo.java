package rmit.team5.springtut.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rmit.team5.springtut.Model.ContactInfo;

import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<ContactInfo, Long> {

    @Query("select c from ContactInfo c where c.phoneNumber LIKE ?1")
    Optional<ContactInfo> findByPhoneNumber (String phoneNum);

}
