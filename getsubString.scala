  def fun(str: String): String = {
    def recc(res: String): String = {
      val length = res.length
      length match {
        case 0 => res
        case _ => {
          (res(0) != '(', res(length - 1) != ')') match {
            case (true, true)   => recc(res.substring(1, length - 1))
            case (true, false)  => recc(res.substring(1, length))
            case (false, true)  => recc(res.substring(0, length - 1))
            case (false, false) => res
          }
        }
      }
    }
    recc(str)
  }
