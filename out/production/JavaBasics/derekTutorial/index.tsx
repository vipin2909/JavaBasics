import React, { useEffect, useRef, useState } from 'react';
import { TextField, MenuItem, InputAdornment, Typography } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { GTranslate } from '@mui/icons-material';

import SimpleModal from '../../../../components/modal';
import TranslationConF from '../../../../components/modal/translationModal';
import BButton from '../../../../components/buttons';
import TButton from '../../../../components/buttons/transparentButton';
import LocalImages from '../../../../constants/images';
import ActionName from '../../../../constants/actionNames';
import { ReducersState } from '../../../../redux/rootReducer';
import TranslationFilter from '../../../../components/filters/masterDataTranslationFilter';
import MasterDataTranslation from '../../../../components/tables/MasterDataTranslationTable';
import masterDataSelection from '../../../../constants/masterDataCodes';
import {
  doTranslation,
  getAttentionPointsTranslation,
  getLocationsTranslation,
  updateAttentionPointTranslation,
  updateLocationTranslation,
} from './services';
import FilterBtn from '../../../../components/buttons/filterButton';
import MultimediaButton from '../../../../components/buttons/multimediaButton';
import styles from './styles';

function Card({ children, outerStyle }: any) {
  return <div className={outerStyle}>{children}</div>;
}

export default function OperationCode() {
  const classes = styles();
  const [masterDataSelected, setMasterDataSelected] = useState(1);
  const [translatePopup, setTranslatePopup] = useState(false);
  const dispatch = useDispatch();

  const {
    langCode1,
    langCode2,
    language1Filter,
    language2Filter,
    search,
    locationsData,
    attentionPointsData,
    languageId1,
    languageId2,
    isChanged,
  } = useSelector((state: ReducersState) => state.MasterDataTranslationReducer);

  const getFilterCount = () => +language1Filter + +language2Filter + 1;
  const debounceCount = useRef(0);
  const api = () =>
    new Promise((res) => {
      setTimeout(() => {
        res(1);
      }, 500);
    });

  const handleChangemasterDataSelected = (event: any) => {
    const number = event.target.value;
    setMasterDataSelected(number);
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        search: '',
        attentionPointsData: [],
        locationsData: [],
      },
    });
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        search: '',
        page: 1,
      },
    });
  };

  /* ***** Handle search ******* /
  const handleSearch = (event: any) => {
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        search: event.target.value,
        page: 1,
      },
    });
    debounceCount.current += 1;
    const localDebounceCount = debounceCount.current;
    api().then(() => {
      if (localDebounceCount !== debounceCount.current) {
        return;
      }

      if (masterDataSelected === masterDataSelection.attentionPoints.index) {
        dispatch(getAttentionPointsTranslation());
        return;
      }
      if (masterDataSelected === masterDataSelection.locations.index) {
        dispatch(getLocationsTranslation());
      }
    });
  };

  /* ****
   * check in list data or not
   */
  const CheckDataInList: any = () => {
    let list = [];
    switch (masterDataSelected) {
      case 1:
        list = attentionPointsData;
        return list;
      case 2:
        list = locationsData;
        return list;

      default:
    }
  };

  /* ****
   * Google Translation master data
    ****** */
  const translate = async () => {
    let list: any = [];
    switch (masterDataSelected) {
      case 1:
        list = attentionPointsData;
        break;
      case 2:
        list = locationsData;
        break;

      default:
    }

    let count = 0;
    dispatch({
      type: ActionName.IS_LOADING,
      payload: !!list.length,
    });
    list?.forEach((data: any, index: number) => {
      doTranslation(data.name, langCode1, (translation: any) => {
        list[index].nameLanguage1 = translation;
        list[index].isLang1Trans = true;
        list[index].lang1TransBy = 'Google';
        list[index].languageId1 = languageId1;
        count += 1;
        if (count === list.length * 2) {
          dispatch({
            type: ActionName.IS_LOADING,
            payload: false,
          });
        }
      });

      doTranslation(data.name, langCode2, (translation: any) => {
        list[index].nameLanguage2 = translation;
        list[index].isLang2Trans = true;
        list[index].lang2TransBy = 'Google';
        list[index].languageId2 = languageId2;
        count += 1;
        if (count === list.length * 2) {
          dispatch({
            type: ActionName.IS_LOADING,
            payload: false,
          });
        }
      });
    });
  };

  const translateOnlyUnTranslate = () => {
    let list: any = [];
    switch (masterDataSelected) {
      case 1:
        list = attentionPointsData;
        break;
      case 2:
        list = locationsData;
        break;

      default:
    }

    let count = 0;
    let count1 = 0;

    list?.forEach((data: any) => {
      if (!data.nameLanguage1) {
        count1 += 1;
      }
      if (!data.nameLanguage2) {
        count1 += 1;
      }
    });
    dispatch({
      type: ActionName.IS_LOADING,
      payload: !!count1,
    });
    setTranslatePopup(false);
    list?.forEach((data: any, index: number) => {
      if (!data.nameLanguage1) {
        doTranslation(data.name, langCode1, (translation: any) => {
          list[index].nameLanguage1 = translation;
          list[index].isLang1Trans = true;
          list[index].lang1TransBy = 'Google';
          list[index].languageId1 = languageId1;
          count += 1;
          if (count === count1) {
            if (masterDataSelected === 1) {
              dispatch({
                type: ActionName.MASTER_DATA_TRANSLATION,
                payload: {
                  attentionPointsData: list,
                },
              });
            } else {
              dispatch({
                type: ActionName.MASTER_DATA_TRANSLATION,
                payload: {
                  locationsData: list,
                },
              });
            }

            dispatch({
              type: ActionName.IS_LOADING,
              payload: false,
            });
          }
        });
      }
      if (!data.nameLanguage2) {
        doTranslation(data.name, langCode2, (translation: any) => {
          list[index].nameLanguage2 = translation;
          list[index].isLang2Trans = true;
          list[index].lang2TransBy = 'Google';
          list[index].languageId2 = languageId2;

          count += 1;
          if (count === count1) {
            if (masterDataSelected === 1) {
              dispatch({
                type: ActionName.MASTER_DATA_TRANSLATION,
                payload: {
                  attentionPointsData: list,
                },
              });
            } else {
              dispatch({
                type: ActionName.MASTER_DATA_TRANSLATION,
                payload: {
                  locationsData: list,
                },
              });
            }
            dispatch({
              type: ActionName.IS_LOADING,
              payload: false,
            });
          }
        });
      }
    });
  };

  const filter = () => (
    <div>
      <Typography className={classes.tileHeading}>
        <TextField
          className={classes.selectStyl}
          select
          value={masterDataSelected}
          onChange={handleChangemasterDataSelected}
          variant="outlined"
        >
          <MenuItem value={1}>Attention Points</MenuItem>
          <MenuItem value={2}>Locations</MenuItem>
        </TextField>
      </Typography>
      <div className={classes.styleOperations}>
        <div className={classes.leftStyleOperations}>
          <div className={classes.inputSearch}>
            <TextField
              className={classes.searchInput}
              variant="outlined"
              placeholder="Search"
              onChange={handleSearch}
              value={search}
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <img
                      alt="Search"
                      src={LocalImages.SEARCH_ICON}
                      className={classes.searchIcon}
                    />
                  </InputAdornment>
                ),
              }}
            />
          </div>
          <span style={{ marginLeft: '20px' }}>
            <MultimediaButton
              isDisabled={CheckDataInList().length === 0}
              icon={<GTranslate color={CheckDataInList().length ? 'primary' : 'disabled'} />}
              text="Google Translate"
              onClick={() => (CheckDataInList().length ? setTranslatePopup(true) : null)}
              isIcon
            />
          </span>
        </div>
        <div>
          <FilterBtn filterCount={getFilterCount()}>
            <TranslationFilter masterDataSelected={masterDataSelected} />
          </FilterBtn>
        </div>
      </div>
    </div>
  );

  const resetTranslation = () => {
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        isChanged: true,
      },
    });
    if (masterDataSelected === masterDataSelection.attentionPoints.index) {
      dispatch(getAttentionPointsTranslation());
      return;
    }
    if (masterDataSelected === masterDataSelection.locations.index) {
      dispatch(getLocationsTranslation());
    }
  };

  const tableOfTranslations = () => {
    switch (masterDataSelected) {
      case 1:
        return (
          <MasterDataTranslation
            listData={attentionPointsData}
            listName={masterDataSelected}
            resetTranslation={resetTranslation}
          />
        );
      case 2:
        return (
          <MasterDataTranslation
            listData={locationsData}
            listName={masterDataSelected}
            resetTranslation={resetTranslation}
          />
        );

      default:
        return null;
    }
  };

  const savetranslation = () => {
    switch (masterDataSelected) {
      case 1:
        dispatch(updateAttentionPointTranslation(attentionPointsData));
        break;
      case 2:
        dispatch(updateLocationTranslation(locationsData));
        break;
      default:
        dispatch(updateAttentionPointTranslation(attentionPointsData));
    }
  };

  useEffect(() => {
    if (masterDataSelected === masterDataSelection.attentionPoints.index) {
      dispatch(getAttentionPointsTranslation());
    }
    if (masterDataSelected === masterDataSelection.locations.index) {
      dispatch(getLocationsTranslation());
    }
  }, [dispatch, masterDataSelected]);

  return (
    <>
      <div className={classes.mainContainer}>
        <div>{filter()}</div>
        {tableOfTranslations()}
        {isChanged && (
          <Card outerStyle={classes.settingsButtonContainer}>
            <TButton handleClose={() => resetTranslation()} />
            <BButton
              type="button"
              text="Save"
              onPress={() => {
                savetranslation();
              }}
            />
          </Card>
        )}
      </div>
      <SimpleModal
        handleClose={() => setTranslatePopup(false)}
        isOpen={translatePopup}
        body={
          <TranslationConF
            handleClose={translateOnlyUnTranslate}
            onDelete={translate}
            title="Google Translate"
            desc="Do yo want to do translate all the Field"
            secondPara="If no then only untranslated field will be translate"
            deleteBtn="Ok"
            canceBtn="No"
            isDelete={false}
          />
        }
      />
    </>
  );
}