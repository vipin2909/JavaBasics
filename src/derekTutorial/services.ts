import axios from 'axios';
import endpoints from '../../../../constants/endpoints';
import { checkResponseStatus, getStorageItem } from '../../../../helpers';
import { API, GLOBAL_API } from '../../../../middlewares';
import { updateGlobalLoader } from '../../../../redux/globalActions';
import ActionNames from '../../../../constants/actionNames';
import showAlert from '../../../../components/alert';

export const doTranslation = async (input: any, languageCode: any, callback: any) => {
  try {
    const { data } = await axios.post(
      `${endpoints.translate}?key=AIzaSyAqtmeOAForQY5lnrvGKvnwS7XwWMPioqc`,
      {
        q: input,
        target: languageCode,
      }
    );
    callback(data.data.translations[0].translatedText);
    return '';
  } catch (err) {
    return '';
  }
};

export const getAttentionPointsTranslation = () => (dispatch: any, getState: any) => {
  const {
    page,
    limit,
    search,
    statusAll,
    language1Filter,
    language2Filter,
    currentSortingInOrder,
    languageId1,
    languageId2,
  } = getState().MasterDataTranslationReducer;

  const getLanguageFilter = () => {
    if (language1Filter && language2Filter) {
      return [languageId1, languageId2].toString();
    }
    if (language1Filter && !language2Filter) {
      return [languageId1].toString();
    }
    if (!language1Filter && language2Filter) {
      return [languageId2].toString();
    }
    return null;
  };

  dispatch(updateGlobalLoader(true));
  const dataToSend = {
    params: {
      page,
      limit: limit * 2,
      orderBy: currentSortingInOrder,
      ...(search.length && { q: search }),
      ...(statusAll === 2 && { translationFilter: 1 }),
      ...(statusAll === 3 && { translationFilter: 0 }),
      ...(getLanguageFilter() && { languageFilter: getLanguageFilter() }),
      languageId1,
      languageId2,
    },
  };

  dispatch(updateGlobalLoader(false));

  API.get(endpoints.masterDataTranslationAttentionPoints, dataToSend)
    .then((response: any) => {
      if (checkResponseStatus(response)) {
        const { data } = response;
        dispatch({
          type: ActionNames.MASTER_DATA_TRANSLATION,
          payload: {
            isChanged: false,
          },
        });

        const mergedData: any = [];
        const { attentionPoints, languageId2Count, languageId1Count, totalCount } =
          data.attentionPoints;

        attentionPoints.forEach((element: any) => {
          let foundIndex = 0;
          const checkUsername = (obj: any, index: any) => {
            if (obj.attentionPointId === element.attentionPointId) foundIndex = index;
            return obj.attentionPointId === element.attentionPointId;
          };

          const { attentionPointId, languageId, translatedDesc, translatedBy } = element;

          if (!mergedData.some(checkUsername)) {
            mergedData.push({
              attentionPointId: attentionPointId,
              name: element.name,
              ...(languageId1 === languageId
                ? { nameLanguage1: translatedDesc }
                : { nameLanguage2: translatedDesc }),
              ...(languageId1 === languageId
                ? { languageId1: languageId }
                : { languageId2: languageId }),
              ...(languageId1 === languageId
                ? { lang1TransBy: translatedBy }
                : { lang2TransBy: translatedBy }),
            });
          } else if (languageId1 === element.languageId) {
            mergedData[foundIndex].languageId1 = languageId;
            mergedData[foundIndex].nameLanguage1 = translatedDesc;
            mergedData[foundIndex].lang1TransBy = element.translatedBy;
          } else {
            mergedData[foundIndex].languageId2 = languageId;
            mergedData[foundIndex].nameLanguage2 = translatedDesc;
            mergedData[foundIndex].lang2TransBy = element.translatedBy;
          }
        });

        dispatch({
          type: ActionNames.MASTER_DATA_TRANSLATION,
          payload: {
            attentionPointsData: mergedData,
            languageId2Count,
            languageId1Count,
            totalCount: totalCount,
          },
        });
      }
      dispatch(updateGlobalLoader(false));
    })
    .catch(() => {
      dispatch(updateGlobalLoader(false));
    });
};

export const getLocationsTranslation = () => (dispatch: any, getState: any) => {
  const {
    page,
    limit,
    search,
    statusAll,
    language1Filter,
    language2Filter,
    currentSortingInOrder,
    languageId1,
    languageId2,
  } = getState().MasterDataTranslationReducer;

  const getLanguageFilter = () => {
    if (language1Filter && language2Filter) {
      return [languageId1, languageId2].toString();
    }
    if (language1Filter && !language2Filter) {
      return [languageId1].toString();
    }
    if (!language1Filter && language2Filter) {
      return [languageId2].toString();
    }
    return null;
  };

  dispatch(updateGlobalLoader(true));
  const dataToSend = {
    params: {
      page,
      limit: limit * 2,
      orderBy: currentSortingInOrder,
      ...(search.length && { q: search }),
      ...(statusAll === 2 && { translationFilter: 1 }),
      ...(statusAll === 3 && { translationFilter: 0 }),
      ...(getLanguageFilter() && { languageFilter: getLanguageFilter() }),
      languageId1,
      languageId2,
    },
  };

  dispatch(updateGlobalLoader(false));

  API.get(endpoints.masterDataTranslationLocations, dataToSend)
    .then((response: any) => {
      if (checkResponseStatus(response)) {
        const { data } = response;
        dispatch({
          type: ActionNames.MASTER_DATA_TRANSLATION,
          payload: {
            isChanged: false,
          },
        });
        const mergedLocationData: any = [];
        const { locations, languageId2Count, languageId1Count, totalCount } = data.locations;
        locations.forEach((element: any) => {
          let foundIndex = 0;
          const checkUsername = (obj: any, index: any) => {
            if (obj.locationId === element.locationId) foundIndex = index;
            return obj.locationId === element.locationId;
          };

          if (!mergedLocationData.some(checkUsername)) {
            mergedLocationData.push({
              locationId: element.locationId,
              name: element.name,
              ...(languageId1 === element.languageId
                ? { nameLanguage1: element.translatedDesc }
                : { nameLanguage2: element.translatedDesc }),
              ...(languageId1 === element.languageId
                ? { languageId1: element.languageId }
                : { languageId2: element.languageId }),
              ...(languageId1 === element.languageId
                ? { lang1TransBy: element.translatedBy }
                : { lang2TransBy: element.translatedBy }),
            });
          } else {
            if (languageId1 === element.languageId) {
              mergedLocationData[foundIndex].languageId1 = element.languageId;
            } else {
              mergedLocationData[foundIndex].languageId2 = element.languageId;
            }

            if (languageId1 === element.languageId) {
              mergedLocationData[foundIndex].nameLanguage1 = element.translatedDesc;
            } else {
              mergedLocationData[foundIndex].nameLanguage2 = element.translatedDesc;
            }

            if (languageId1 === element.languageId) {
              mergedLocationData[foundIndex].lang1TransBy = element.translatedBy;
            } else {
              mergedLocationData[foundIndex].lang2TransBy = element.translatedBy;
            }
          }
        });

        dispatch({
          type: ActionNames.MASTER_DATA_TRANSLATION,
          payload: {
            locationsData: mergedLocationData,
            languageId2Count,
            languageId1Count,
            totalCount: totalCount,
          },
        });
      }
      dispatch(updateGlobalLoader(false));
    })
    .catch(() => {
      dispatch(updateGlobalLoader(false));
    });
};

export const getFactoryLanguagesData = () => (dispatch: any) => {
  dispatch(updateGlobalLoader(true));
  GLOBAL_API.get(`${endpoints.getFactoryLanguages}${getStorageItem('factoryId')}`)
    .then((response: any) => {
      const { data } = response;
      dispatch({
        type: ActionNames.MASTER_DATA_TRANSLATION,
        payload: {
          factoryLanguages: data?.data[0]?.listLanguages,
        },
      });
      const languagesList = data?.data[0]?.listLanguages;
      if (languagesList) {
        dispatch({
          type: ActionNames.MASTER_DATA_TRANSLATION,
          payload: {
            langCode1: languagesList[0]?.language,
            langCode2: languagesList[1]?.language,
            language1: languagesList[0]?.desc1,
            language2: languagesList[1]?.desc1,
            languageId1: languagesList[0]?.id,
            languageId2: languagesList[1]?.id,
          },
        });
      }
      dispatch(updateGlobalLoader(false));
    })
    .catch(() => dispatch(updateGlobalLoader(false)));
  return dispatch(updateGlobalLoader(false));
};

export const updateLocationTranslation = (data: any) => (dispatch: any) => {
  dispatch({
    type: ActionNames.IS_LOADING,
    payload: true,
  });

  const locationSplittedData: any = [];
  data.forEach((element: any) => {
    if (element.languageId1) {
      locationSplittedData.push({
        locationId: element.locationId,
        languageId: element.languageId1,
        translatedDesc: element.nameLanguage1,
        ...(element.lang1TransBy &&
          element.lang1TransBy !== '' && { translatedBy: element.lang1TransBy }),
      });
    }
    if (element.languageId2) {
      locationSplittedData.push({
        locationId: element.locationId,
        languageId: element.languageId2,
        translatedDesc: element.nameLanguage2,
        ...(element.lang1TransBy &&
          element.lang2TransBy !== '' && { translatedBy: element.lang2TransBy }),
      });
    }
  });

  const dataToSend = {
    adds: locationSplittedData,
  };

  API.post(endpoints.masterDataTranslationLocations, dataToSend)
    .then((response: any) => {
      if (checkResponseStatus(response)) {
        showAlert(1, 'Data updated successfully!');
        dispatch(getLocationsTranslation());
      }

      dispatch(updateGlobalLoader(false));
    })
    .catch((error) => {
      const { response } = error;
      showAlert(2, response?.data?.message);
      dispatch(updateGlobalLoader(false));
    });
};

export const updateAttentionPointTranslation = (data: any) => (dispatch: any) => {
  dispatch({
    type: ActionNames.IS_LOADING,
    payload: true,
  });

  const splittedData: any = [];
  data.forEach((element: any) => {
    if (element.languageId1) {
      splittedData.push({
        attentionPointId: element.attentionPointId,
        languageId: element.languageId1,
        translatedDesc:
          element.nameLanguage1 && element.nameLanguage1 !== '' ? element.nameLanguage1 : null,
        ...(element.lang1TransBy &&
          element.lang1TransBy !== '' && {
            translatedBy:
              element.lang1TransBy && element.lang1TransBy !== '' ? element.lang1TransBy : null,
          }),
      });
    }
    if (element.languageId2) {
      splittedData.push({
        attentionPointId: element.attentionPointId,
        languageId: element.languageId2,
        translatedDesc:
          element.nameLanguage2 && element.nameLanguage2 !== '' ? element.nameLanguage2 : null,
        ...(element.lang1TransBy &&
          element.lang2TransBy !== '' && {
            translatedBy:
              element.lang2TransBy && element.lang2TransBy !== '' ? element.lang2TransBy : null,
          }),
      });
    }
  });

  const dataToSend = {
    adds: splittedData,
  };

  API.post(endpoints.masterDataTranslationAttentionPoints, dataToSend)
    .then((response: any) => {
      if (checkResponseStatus(response)) {
        showAlert(1, 'Data updated successfully!');
        dispatch(getAttentionPointsTranslation());
      }

      dispatch(updateGlobalLoader(false));
    })
    .catch((error) => {
      const { response } = error;
      showAlert(2, response?.data?.message);
      dispatch(updateGlobalLoader(false));
    });
};