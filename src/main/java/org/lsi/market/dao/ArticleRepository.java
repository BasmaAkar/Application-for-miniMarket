package org.lsi.market.dao;

import org.lsi.market.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long>{

}
