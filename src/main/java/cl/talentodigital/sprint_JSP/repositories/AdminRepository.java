package cl.talentodigital.sprint_JSP.repositories;

import cl.talentodigital.sprint_JSP.models.AdminModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminModel,Long> {
}
