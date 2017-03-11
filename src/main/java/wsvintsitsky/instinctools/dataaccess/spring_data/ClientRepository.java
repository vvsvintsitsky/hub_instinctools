package wsvintsitsky.instinctools.dataaccess.spring_data;

import org.springframework.data.jpa.repository.JpaRepository;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
