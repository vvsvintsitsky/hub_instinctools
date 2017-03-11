package wsvintsitsky.instinctools.dataaccess.spring_data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByClient_Id(Long id);
}
